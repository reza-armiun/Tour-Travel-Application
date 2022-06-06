package razarm.tosan.security.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import razarm.tosan.controller.dto.auth.Profile;
import razarm.tosan.controller.dto.auth.SignupRequest;
import razarm.tosan.exception.PasswordNotMatchException;
import razarm.tosan.security.model.UpdatePasswordRequest;
import razarm.tosan.security.model.UserAuthDetails;
import razarm.tosan.service.AuthService;

import javax.naming.directory.InvalidAttributeValueException;
import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("v1")
@AllArgsConstructor
@Slf4j
public class AuthController {
    private final AuthService authService;


    @GetMapping("signedin")
    public ResponseEntity<Optional<UserAuthDetails>> checkAuth(Principal principal) {
        var authDetails = UserAuthDetails.builder().username(principal.getName()).authenticated(true).build();
        return ResponseEntity.ok(Optional.of(authDetails));
    }


    @PostMapping("signup")
    public ResponseEntity<Optional<UserAuthDetails>> signup(@RequestBody SignupRequest signupRequest) throws InvalidAttributeValueException {
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
        log.debug("user : {}  password  changed successfully", updatePasswordRequest.getUsername());
        return ResponseEntity.ok().build();
    }

    @PutMapping("profile")
    public ResponseEntity<Void> updateProfile(@RequestBody Profile profile, Principal principal) {
        this.authService.updateUserProfile(principal.getName(), profile);
        return ResponseEntity.ok().build();
    }
}
