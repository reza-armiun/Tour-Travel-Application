package razarm.tosan.repository;

import razarm.tosan.repository.domain.auth.PremiumUser;

public interface PremiumUserRepository extends CrudRepository<PremiumUser, String> {

    PremiumUser findByUsername(String username);

}
