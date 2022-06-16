package razarm.tosan.service.impl;

import com.google.common.io.Files;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
import razarm.tosan.controller.dto.auth.*;
import razarm.tosan.controller.dto.tour.BookingInfo;
import razarm.tosan.controller.mapper.user.UserToProfile;
import razarm.tosan.controller.mapper.user.UserToUserDto;
import razarm.tosan.exception.UserNotFoundException;
import razarm.tosan.exception.InvalidCredentialException;
import razarm.tosan.exception.PasswordNotMatchException;
import razarm.tosan.props.AppProperties;
import razarm.tosan.repository.TourRepository;
import razarm.tosan.repository.UserRepository;
import razarm.tosan.repository.UserSessionRepository;
import razarm.tosan.repository.domain.auth.*;
import razarm.tosan.repository.domain.location.Address;
import razarm.tosan.repository.domain.location.City;
import razarm.tosan.repository.domain.location.Country;
import razarm.tosan.security.model.UpdatePasswordRequest;
import razarm.tosan.service.AuthService;

import javax.naming.directory.InvalidAttributeValueException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserSessionRepository userSessionRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserToUserDto userToUserDto;
    private final UserToProfile userToProfile;
    private final TourRepository tourRepository;

    @Value("${app.server.address}")
    private String appServerAddress;

    public AuthServiceImpl(UserRepository userRepository, UserSessionRepository userSessionRepository, PasswordEncoder passwordEncoder, UserToUserDto userToUserDto, UserToProfile userToProfile, TourRepository tourRepository) {
        this.userRepository = userRepository;
        this.userSessionRepository = userSessionRepository;
        this.passwordEncoder = passwordEncoder;
        this.userToUserDto = userToUserDto;
        this.userToProfile = userToProfile;
        this.tourRepository = tourRepository;
    }


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
         profile.setBookings(user.getBookings().stream().map(booking ->
                            BookingInfo.builder().id(booking.getId())
                           .tourId(booking.getTour().getId())
                           .tourName(this.tourRepository.findById(booking.getTour().getId()).getName()) //TOD
                           .date(booking.getDate().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                           .build()).collect(Collectors.toUnmodifiableSet()));
        return profile;
    }

    @Override
    public void updateUserProfile(String username, Profile profile) {
        var user = this.userRepository.findByUsername(profile.getUsername());
        if(!username.equals(profile.getUsername()))  throw new UserNotFoundException("invalid username");
        user.setName(profile.getUsername());
        user.setPhone(profile.getPhone());
        user.setEmail(profile.getEmail());
        user.setNationalId(profile.getNationalId());
        var address = profile.getAddress();
        if(address != null) {
            user.setAddress(
                    Address.AddressBuilder.anAddress()
                            .street(address.getStreet())
                            .postalCode(address.getPostalCode())
                            .city(
                                    City.CityBuilder.aCity()
                                            .name(address.getCity())
                                            .zipCode(address.getZipCode())
                                            .country(Country.CountryBuilder.aCountry()
                                                    .name(address.getCountry())
                                                    .countryCode(address.getCountryCode())
                                                    .build())
                                            .build())
                            .build());
        }
        userRepository.update(user);
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

    @Override
    public String updateProfileImage(String username, MultipartFile file) throws IOException {
        var user =this.userRepository.findByUsername(username);
        String newImgUrl = appServerAddress + "/v1/profile/img/"+ Instant.now();
        if(user != null) {
            var uploadDir = new File("./files");
            var fileName = username + "." + Files.getFileExtension(Objects.requireNonNull(file.getOriginalFilename()));
            var isDir = Files.isDirectory().test(uploadDir);
            if(!isDir) {
                java.nio.file.Files.createDirectory(Path.of("./files"));
            }
            try (InputStream inputStream = file.getInputStream()) {
                String dirPath = "./files/" + user.getId() +"/";
                var path = Path.of(dirPath);
                FileSystemUtils.deleteRecursively(path);
                java.nio.file.Files.createDirectory(Path.of(dirPath));
                java.nio.file.Files.copy(inputStream, Path.of(dirPath + fileName ), StandardCopyOption.REPLACE_EXISTING);

                user.setImageUrl(newImgUrl);
                userRepository.update(user);

            } catch (IOException ioe) {
                throw new IOException("Could not save image file: " + fileName, ioe);
            }

        }
        return newImgUrl;
    }

    @Override
    public Resource downloadProfileImage(String username) {
        var user = this.userRepository.findByUsername(username);
        var photoDir ="./files/" + user.getId();
        try {
            List<Path> result = findByFileName(Path.of(photoDir ), username);
            if (result.size() > 0) {
                Resource resource = new UrlResource(result.get(0).toAbsolutePath().toUri());
                if (resource.exists()) return resource;
                else throw new MalformedURLException();
            }
        } catch (IOException e) {
            return null;
        }
        return null;
    }


    public static List<Path> findByFileName(Path path, String fileName)
            throws IOException {

        List<Path> result;
        try (Stream<Path> walk = java.nio.file.Files.walk(path)) {
            result = walk.filter(java.nio.file.Files::isRegularFile)
                         .filter(p -> p.toString().contains(fileName))
                         .collect(Collectors.toList());
        }
        return result;

    }

}
