package razarm.tosan.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import razarm.tosan.controller.dto.auth.*;
import razarm.tosan.controller.dto.tour.BookingInfo;
import razarm.tosan.controller.mapper.user.UserToProfile;
import razarm.tosan.controller.mapper.user.UserToUserDto;
import razarm.tosan.exception.UserNotFoundException;
import razarm.tosan.exception.InvalidCredentialException;
import razarm.tosan.exception.PasswordNotMatchException;
import razarm.tosan.repository.UserRepository;
import razarm.tosan.repository.UserSessionRepository;
import razarm.tosan.repository.domain.auth.*;
import razarm.tosan.security.model.UpdatePasswordRequest;
import razarm.tosan.service.AuthService;
import razarm.tosan.service.tour.BookingService;

import javax.naming.directory.InvalidAttributeValueException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserSessionRepository userSessionRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserToUserDto userToUserDto;
    private final UserToProfile userToProfile;
    private final BookingService bookingService;



    @Override
    public User findUserByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public UserDto signup(SignupRequest request) throws InvalidAttributeValueException {
        if(!request.getPassword().equals(request.getRePassword())) throw new PasswordNotMatchException("password not match");
        if(request.getPassword().length() < 8) throw new InvalidAttributeValueException("password must have more than 7 characters");

        final var newUser =
                PremiumUser.PremiumUserBuilder.aPremiumUser()
                                              .name(request.getName())
                                              .username(request.getUsername())
//                        .password(this.passwordEncoder.encrypt(request.getPassword().toCharArray()))
                                              .password(this.passwordEncoder.encode(request.getPassword()))
                                              .email(request.getEmail())
                                              .type(PremiumType.NORMAL)
                                              .authorities(
                                Set.of(
                                        Authority.AuthorityBuilder.anAuthority().name("BASIC")
                                                                  .build())) // TODO refactor this
                                              .build();
        final var savedUser = this.userRepository.save(newUser);
        return this.userToUserDto.convert(savedUser);
    }

    @Override
    public UserDetails login(LoginRequest request) throws UserNotFoundException {
        var user = userRepository.findByUsername(request.getUsername());
//        var isValidPw = passwordEncoder.authenticate(request.getPassword().toCharArray(), user.getPassword());
        var isValidPw = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if(!isValidPw)
            throw new InvalidCredentialException("invalid credential , please try again");

        final Instant now = Instant.now();
        var session = new UserSession(user.getUsername(), user.getPassword().substring(0, 8), now, now.plus(15, ChronoUnit.DAYS));
         userSessionRepository.save(session);
         return new UserDetails() { //TODO refactor this
             @Override
             public String getUsername() {
                 return user.getUsername();
             }

             @Override
             public Collection<? extends GrantedAuthority> getAuthorities() {
                 return user.getAuthorities();
             }
             @Override
             public String getPassword() {
                 return null;
             }

             @Override
             public boolean isAccountNonExpired() {
                 return false;
             }

             @Override
             public boolean isAccountNonLocked() {
                 return false;
             }

             @Override
             public boolean isCredentialsNonExpired() {
                 return false;
             }

             @Override
             public boolean isEnabled() {
                 return true;
             }
         };
    }

    @Override
    public void logout(LogoutWithCredential request) throws UserNotFoundException {
        var user = userRepository.findByUsername(request.getUsername());
//        var passwordMatch = passwordEncoder.authenticate(request.getPassword().toCharArray(), user.getPassword());
        var passwordMatch = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if(!passwordMatch) throw new IllegalArgumentException("invalid password");
        userSessionRepository.deleteById(user.getUsername());
    }

    @Override
    public List<UserDto> findAllUsers() {
        return userRepository.findAll().stream()
                .map(userToUserDto::convert)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public boolean checkUsername(String username) {
        try {
            return this.userRepository.findByUsername(username) != null;
        }catch (UserNotFoundException e) {
            return false;
        }
    }

    @Override
    public Profile getUserProfileByUsername(String username) {
        var user = this.userRepository.findByUsername(username);
        var profile = this.userToProfile.convert(user);
        if(user instanceof PremiumUser) {
            var premiumUser = (PremiumUser) user;
            profile.setBookings(premiumUser.getBookings().stream().map(booking -> {
                var bk =  this.bookingService.findById(booking.getId());
                return BookingInfo.builder().id(bk.getId())
                                  .tourName(bk.getTour().getName())
                                  .date(bk.getDate())
                                  .build();
            }).collect(Collectors.toUnmodifiableSet()));
        }
        return profile;
    }

    @Override
    public void updatePassword(UpdatePasswordRequest updatePasswordRequest) throws PasswordNotMatchException {
        if(!updatePasswordRequest.getPassword().equals(updatePasswordRequest.getRePassword())) throw new PasswordNotMatchException("password not match");
        var user = this.userRepository
                .findByUsername(updatePasswordRequest.getUsername());

        var isMatched = passwordEncoder.matches(updatePasswordRequest.getOldPassword(), user.getPassword());
        if(!isMatched ) throw new InvalidCredentialException("invalid credentials");
        user.setPassword(this.passwordEncoder.encode(updatePasswordRequest.getPassword()) );
         this.userRepository.update(user);
    }


}
