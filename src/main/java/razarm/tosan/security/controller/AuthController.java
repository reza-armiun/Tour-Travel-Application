package razarm.tosan.security.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import razarm.tosan.controller.dto.auth.Profile;
import razarm.tosan.controller.dto.auth.SignupRequest;
import razarm.tosan.exception.PasswordNotMatchException;
import razarm.tosan.security.model.UpdatePasswordRequest;
import razarm.tosan.security.model.UserAuthDetails;
import razarm.tosan.service.AuthService;

import javax.naming.directory.InvalidAttributeValueException;
import java.io.IOException;
import java.security.Principal;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1")
@AllArgsConstructor
@Slf4j
public class AuthController {
    private final AuthService authService;


    @GetMapping("signedin")
    public ResponseEntity<Optional<UserAuthDetails>> checkAuth(Authentication authentication) {
        var authDetails =
                UserAuthDetails.builder()
                        .username(authentication.getName())
                        .authenticated(true)
                        .authorities(
                                authentication.getAuthorities().stream()
                                        .map(GrantedAuthority::getAuthority)
                                        .collect(Collectors.toUnmodifiableSet()))
                        .build();
        return ResponseEntity.ok(Optional.of(authDetails));
    }


    @PostMapping("signup")
    public  ResponseEntity<Optional<UserAuthDetails>> signup(@RequestBody SignupRequest signupRequest) throws InvalidAttributeValueException {
        this.authService.signup(signupRequest);
        var authDetails = UserAuthDetails.builder().username(signupRequest.getUsername());
        return ResponseEntity.ok(Optional.of(authDetails.build()));
    }

    @GetMapping("check-username")
    public ResponseEntity<Boolean> checkUsername(@RequestParam("username")String username) {
        return ResponseEntity.ok(this.authService.checkUsername(username));
    }


    @GetMapping("profile")
    public ResponseEntity<Profile> getProfile(@RequestParam("username")String username) {
        return  ResponseEntity
                .ok(authService.getUserProfileByUsername(username));
    }


    @PutMapping("change-password")
    public ResponseEntity<Void> updatePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest) throws PasswordNotMatchException {
        this.authService.updatePassword(updatePasswordRequest);
        log.info("user : {}  password  changed successfully", updatePasswordRequest.getUsername());
        return ResponseEntity.ok().build();
    }

    @PutMapping("profile")
    public ResponseEntity<Void> updateProfile(@RequestBody Profile profile, Principal principal) {
        this.authService.updateUserProfile(principal.getName(), profile);
        return ResponseEntity.ok().build();
    }

    @PostMapping("profile/img")
    public ResponseEntity<String> updateProfileImg(@RequestPart("file") MultipartFile file, Authentication authentication) throws IOException {
        return ResponseEntity.ok(authService.updateProfileImage(authentication.getName(), file));
    }

    @GetMapping("profile/img/{time}")
    public ResponseEntity<Resource> downloadProfileImage(Authentication authentication, @PathVariable String time) {
        return ResponseEntity.ok(this.authService.downloadProfileImage(authentication.getName()));
    }
}
