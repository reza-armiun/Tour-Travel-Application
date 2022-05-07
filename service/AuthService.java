package razarm.tosan.service;

import razarm.tosan.controller.dto.auth.LoginRequest;
import razarm.tosan.controller.dto.auth.LogoutWithCredential;
import razarm.tosan.controller.dto.auth.SignupRequest;
import razarm.tosan.controller.dto.auth.UserDto;
import razarm.tosan.exception.UserNotFoundException;

import javax.naming.directory.InvalidAttributeValueException;
import java.util.List;


public interface AuthService {
    UserDto signup(SignupRequest request) throws InvalidAttributeValueException;
    String  login(LoginRequest request) throws UserNotFoundException;
    void  logout(LogoutWithCredential request) throws UserNotFoundException;

    List<UserDto> findAllUsers();//TODO REMOVE THIS

}
