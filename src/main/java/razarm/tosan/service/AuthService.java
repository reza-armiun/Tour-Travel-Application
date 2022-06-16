package razarm.tosan.service;

import org.springframework.core.io.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;
import razarm.tosan.controller.dto.auth.*;
import razarm.tosan.exception.PasswordNotMatchException;
import razarm.tosan.exception.UserNotFoundException;
import razarm.tosan.repository.domain.auth.User;
import razarm.tosan.security.model.UpdatePasswordRequest;

import javax.naming.directory.InvalidAttributeValueException;
import java.io.IOException;
import java.util.List;


public interface AuthService {
    User findUserByUsername(String username);
    UserDto signup(SignupRequest request) throws InvalidAttributeValueException;
    UserDetails login(LoginRequest request) throws UserNotFoundException; //TODO change return type
    void  logout(LogoutWithCredential request) throws UserNotFoundException;
    List<UserDto> findAllUsers();//TODO REMOVE THIS

    boolean checkUsername(String username);

    Profile getUserProfileByUsername(String username);
    void updateUserProfile(String username, Profile profile);

    void updatePassword(UpdatePasswordRequest updatePasswordRequest) throws PasswordNotMatchException;

    String updateProfileImage(String username, MultipartFile file) throws IOException;
    Resource downloadProfileImage(String username);
}
