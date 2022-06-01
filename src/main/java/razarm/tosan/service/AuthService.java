package razarm.tosan.service;

import org.springframework.security.core.userdetails.UserDetails;
import razarm.tosan.controller.dto.auth.*;
import razarm.tosan.exception.PasswordNotMatchException;
import razarm.tosan.exception.UserNotFoundException;
import razarm.tosan.repository.domain.auth.User;
import razarm.tosan.security.model.UpdatePasswordRequest;

import javax.naming.directory.InvalidAttributeValueException;
import java.util.List;


public interface AuthService {
    User findUserByUsername(String username);
    UserDto signup(SignupRequest request) throws InvalidAttributeValueException;
    UserDetails login(LoginRequest request) throws UserNotFoundException; //TODO change return type
    void  logout(LogoutWithCredential request) throws UserNotFoundException;
    List<UserDto> findAllUsers();//TODO REMOVE THIS

    boolean checkUsername(String username);

    Profile getUserProfileByUsername(String username);

    void updatePassword(UpdatePasswordRequest updatePasswordRequest) throws PasswordNotMatchException;
}
