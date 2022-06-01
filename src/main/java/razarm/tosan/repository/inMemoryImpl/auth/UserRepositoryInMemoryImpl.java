package razarm.tosan.repository.inMemoryImpl.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import razarm.tosan.exception.UserNotFoundException;
import razarm.tosan.repository.data.auth.PremiumUserData;
import razarm.tosan.repository.data.auth.UserData;
import razarm.tosan.repository.UserRepository;
import razarm.tosan.repository.domain.Booking;
import razarm.tosan.repository.domain.auth.PremiumUser;
import razarm.tosan.repository.domain.auth.User;
import razarm.tosan.repository.mapper.auth.UserDataToUser;
import razarm.tosan.repository.mapper.auth.UserToUserData;

import java.util.*;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class UserRepositoryInMemoryImpl implements UserRepository {
    private Map<String, UserData> userDataMap = new HashMap<>();

    private final UserToUserData userToUserData ;
    private final UserDataToUser userDataToUser;

    public UserRepositoryInMemoryImpl(UserToUserData userToUserData, UserDataToUser userDataToUser) {
        this.userToUserData = userToUserData;
        this.userDataToUser = userDataToUser;
    }


    @Override
    public User save(User user) {
        final var userData =  userToUserData.convert(user);
        userDataMap.put(userData.getId(), userData);
        return (User) user.cloneWithId(userData.getId());
    }

    @Override
    public void update(User user) {
        final var userData =  userToUserData.convert(user);
        userDataMap.put(userData.getId(), userData);
    }

    @Override
    public void deleteById(String s) {
        userDataMap.remove(s);
    }

    @Override
    public User findById(String s) {
        return userDataToUser.convert(userDataMap.get(s));
    }

    @Override
    public List<User> findAll() {
        return userDataMap.values().stream().map(userDataToUser::convert).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public User findByUsername(String username) throws UserNotFoundException {
        var user =
                userDataMap.values().stream()
                        .filter(userData -> userData.getUsername().equals(username))
                        .findAny()
                        .orElseThrow(UserNotFoundException::new);
        User convertedUser = userDataToUser.convert(user);
        PremiumUser premiumUser = null;
        if(user instanceof PremiumUserData) {  //TODO refactor
            var premiumUserData = (PremiumUserData)user;
            premiumUser = ((PremiumUser) convertedUser)
                    .cloneWithBookings(
                            premiumUserData.getBookingIds().stream()
                                    .map(id -> Booking.BookingBuilder.aBooking().id(id).build())
                                    .collect(Collectors.toUnmodifiableSet()));
        }

        return premiumUser != null ? premiumUser : convertedUser;
    }
}
