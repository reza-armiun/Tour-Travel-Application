package razarm.tosan.service;

import razarm.tosan.controller.dto.auth.LoginRequest;
import razarm.tosan.controller.dto.auth.LogoutWithCredential;
import razarm.tosan.controller.dto.auth.SignupRequest;
import razarm.tosan.controller.dto.auth.UserDto;
import razarm.tosan.exception.UserNotFoundException;
import razarm.tosan.repository.domain.auth.User;
import razarm.tosan.repository.domain.auth.UserDetails;

import javax.naming.directory.InvalidAttributeValueException;
import java.util.List;


public interface AuthService {
    User findUserByUsername(String username);
    UserDto signup(SignupRequest request) throws InvalidAttributeValueException;
    UserDetails login(LoginRequest request) throws UserNotFoundException; //TODO change return type
    void  logout(LogoutWithCredential request) throws UserNotFoundException;

    List<UserDto> findAllUsers();//TODO REMOVE THIS

}
