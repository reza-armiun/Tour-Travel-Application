package razarm.tosan.service.impl;

import razarm.tosan.repository.domain.auth.PremiumUser;
import razarm.tosan.repository.domain.auth.UserSession;
import razarm.tosan.controller.dto.auth.LoginRequest;
import razarm.tosan.controller.dto.auth.LogoutWithCredential;
import razarm.tosan.controller.dto.auth.SignupRequest;
import razarm.tosan.controller.dto.auth.UserDto;
import razarm.tosan.exception.InvalidCredentialException;
import razarm.tosan.exception.PasswordNotMatchException;
import razarm.tosan.controller.mapper.user.PremiumUserToPremiumUserDto;
import razarm.tosan.repository.PremiumUserRepository;
import razarm.tosan.repository.UserSessionRepository;
import razarm.tosan.service.AuthService;
import razarm.tosan.utility.PasswordEncoder;

import javax.naming.directory.InvalidAttributeValueException;
import java.time.Instant;


public class AuthServiceImpl implements AuthService {

    private final PremiumUserRepository userRepository;
    private final UserSessionRepository userSessionRepository;
    private final PasswordEncoder passwordEncoder;
    private final PremiumUserToPremiumUserDto premiumUserToPremiumUserDto;

    public AuthServiceImpl(PremiumUserRepository userRepository, UserSessionRepository userSessionRepository
            , PasswordEncoder passwordEncoder, PremiumUserToPremiumUserDto premiumUserToPremiumUserDto) {
        this.userRepository = userRepository;
        this.userSessionRepository = userSessionRepository;
        this.passwordEncoder = passwordEncoder;
        this.premiumUserToPremiumUserDto = premiumUserToPremiumUserDto;
    }


    @Override
    public UserDto signup(SignupRequest request) throws InvalidAttributeValueException {
        if(!request.getPassword().equals(request.getRePassword())) throw new PasswordNotMatchException("password not match");
        if(request.getPassword().length() < 8) throw new InvalidAttributeValueException("password must have more than 7 characters");

        final var newUser = PremiumUser.PremiumUserBuilder.aPremiumUser()
                                                    .name(request.getName())
                                                    .username(request.getUsername())
                                                    .password(this.passwordEncoder.encrypt(request.getPassword().toCharArray()))
                                                    .email(request.getEmail())
                                                    .build();
        final var savedUser = this.userRepository.save(newUser);
        return this.premiumUserToPremiumUserDto.convert(savedUser);
    }

    @Override
    public String login(LoginRequest request) {
        var user = userRepository.findByUsername(request.getUsername());
        var isValidPw = passwordEncoder.authenticate(request.getPassword().toCharArray(), user.getPassword());
        if(!isValidPw)
            throw new InvalidCredentialException("invalid credential , please try again");

        var session = new UserSession(user.getUsername(), user.getPassword().substring(0, 8), Instant.now());
        return userSessionRepository.save(session).getSessionId();

    }

    @Override
    public void logout(LogoutWithCredential request) {
        var user = userRepository.findByUsername(request.getUsername());
        var passwordMatch = passwordEncoder.authenticate(request.getPassword().toCharArray(), user.getPassword());
        if(!passwordMatch) throw new IllegalArgumentException("invalid password");
        userSessionRepository.deleteById(user.getUsername());
    }
}
