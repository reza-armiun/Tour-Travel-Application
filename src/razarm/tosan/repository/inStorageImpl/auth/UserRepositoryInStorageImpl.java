package razarm.tosan.repository.inStorageImpl.auth;

import razarm.tosan.AppContextHolder;
import razarm.tosan.exception.UserNotFoundException;
import razarm.tosan.repository.UserRepository;
import razarm.tosan.repository.data.auth.UserData;
import razarm.tosan.repository.domain.auth.User;
import razarm.tosan.repository.inStorageImpl.InStorageRepository;
import razarm.tosan.repository.mapper.auth.UserDataToUser;
import razarm.tosan.repository.mapper.auth.UserToUserData;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepositoryInStorageImpl implements UserRepository, InStorageRepository<UserData> {
    private FileOutputStream fos;
    private FileInputStream fis;
    private ObjectOutputStream os;
    private ObjectInputStream in;


     {
        try {
            fos = new FileOutputStream("User.data");
            fis = new FileInputStream("User.data");
            os  =new ObjectOutputStream(fos);
            in = new ObjectInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private final UserToUserData userToUserData ;
    private final UserDataToUser userDataToUser;

    public UserRepositoryInStorageImpl(UserToUserData userToUserData, UserDataToUser userDataToUser) {
        this.userToUserData = userToUserData;
        this.userDataToUser = userDataToUser;
    }


    @Override
    public User save(User user) {
        final var userData =  userToUserData.convert(user);
        writeObject(userData);
        return (User) user.cloneWithId(userData.getId());
    }

    @Override
    public void update(User user) {
        final var userData =  userToUserData.convert(user);
        updateObject(userData);
    }

    @Override
    public void deleteById(String s) {
        deleteObject(s);
    }

    @Override
    public User findById(String s) throws UserNotFoundException {
        return readObject().stream()
                .filter(userData -> userData.getId().equals(s))
                .map(userDataToUser::convert)
                .findFirst()
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<User> findAll() {
        return readObject().stream().map(userDataToUser::convert).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public User findByUsername(String username) {
        return readObject().stream()
                .filter(userData -> userData.getUsername().equals(username))
                .map(userDataToUser::convert)
                .findFirst()
                .orElse(null);
    }



    @Override
    public ObjectOutputStream getObjectOutputStream() {
        return os;
    }

    @Override
    public ObjectInputStream getObjectInputStream() {
        return in;
    }
}
