package razarm.tosan.service.impl;

import razarm.tosan.controller.mapper.user.UserToUserDto;
import razarm.tosan.exception.UserNotFoundException;
import razarm.tosan.repository.domain.auth.*;
import razarm.tosan.controller.dto.auth.LoginRequest;
import razarm.tosan.controller.dto.auth.LogoutWithCredential;
import razarm.tosan.controller.dto.auth.SignupRequest;
import razarm.tosan.controller.dto.auth.UserDto;
import razarm.tosan.exception.InvalidCredentialException;
import razarm.tosan.exception.PasswordNotMatchException;
import razarm.tosan.repository.UserRepository;
import razarm.tosan.repository.UserSessionRepository;
import razarm.tosan.service.AuthService;
import razarm.tosan.utility.PasswordEncoder;

import javax.naming.directory.InvalidAttributeValueException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserSessionRepository userSessionRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserToUserDto userToUserDto;

    public AuthServiceImpl(UserRepository userRepository, UserSessionRepository userSessionRepository
            , PasswordEncoder passwordEncoder, UserToUserDto userToUserDto) {
        this.userRepository = userRepository;
        this.userSessionRepository = userSessionRepository;
        this.passwordEncoder = passwordEncoder;
        this.userToUserDto = userToUserDto;
    }


    @Override
    public UserDto signup(SignupRequest request) throws InvalidAttributeValueException {
        if(!request.getPassword().equals(request.getRePassword())) throw new PasswordNotMatchException("password not match");
        if(request.getPassword().length() < 8) throw new InvalidAttributeValueException("password must have more than 7 characters");

        final var newUser =
                PremiumUser.PremiumUserBuilder.aPremiumUser()
                        .name(request.getName())
                        .username(request.getUsername())
                        .password(this.passwordEncoder.encrypt(request.getPassword().toCharArray()))
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
        var isValidPw = passwordEncoder.authenticate(request.getPassword().toCharArray(), user.getPassword());
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
             public String getEmail() {
                 return user.getEmail();
             }

             @Override
             public String getPassword() {
                 return null;
             }

             @Override
             public Collection<? extends Authority> getAuthorities() {
                 return user.getAuthorities();
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
        var passwordMatch = passwordEncoder.authenticate(request.getPassword().toCharArray(), user.getPassword());
        if(!passwordMatch) throw new IllegalArgumentException("invalid password");
        userSessionRepository.deleteById(user.getUsername());
    }

    @Override
    public List<UserDto> findAllUsers() {
        return userRepository.findAll().stream()
                .map(userToUserDto::convert)
                .collect(Collectors.toUnmodifiableList());
    }
}
