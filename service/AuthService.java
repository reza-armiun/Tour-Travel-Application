package razarm.tosan.service;

import razarm.tosan.controller.dto.auth.LoginRequest;
import razarm.tosan.controller.dto.auth.LogoutWithCredential;
import razarm.tosan.controller.dto.auth.SignupRequest;
import razarm.tosan.controller.dto.auth.UserDto;

import javax.naming.directory.InvalidAttributeValueException;


public interface AuthService {
    UserDto signup(SignupRequest request) throws InvalidAttributeValueException;
    String  login(LoginRequest request);
    void  logout(LogoutWithCredential request);
}
