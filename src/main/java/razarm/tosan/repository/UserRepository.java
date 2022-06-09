package razarm.tosan.repository;

import razarm.tosan.exception.UserNotFoundException;
import razarm.tosan.repository.domain.auth.User;

public interface UserRepository extends CrudRepository<User, String> {
    User findByUsername(String username) throws UserNotFoundException;

}
