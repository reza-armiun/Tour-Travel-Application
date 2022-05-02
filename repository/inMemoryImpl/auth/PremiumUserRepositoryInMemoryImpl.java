package razarm.tosan.repository.inMemoryImpl.auth;

import razarm.tosan.repository.data.auth.PremiumUserData;
import razarm.tosan.repository.domain.auth.PremiumUser;
import razarm.tosan.repository.PremiumUserRepository;
import razarm.tosan.repository.inMemoryImpl.IdGenerator;
import razarm.tosan.repository.mapper.auth.PremiumUserDataToPremiumUser;
import razarm.tosan.repository.mapper.auth.PremiumUserToPremiumUserData;

import java.util.*;
import java.util.stream.Collectors;

public class PremiumUserRepositoryInMemoryImpl implements PremiumUserRepository {
    private static  Map<String, PremiumUserData> userMap = new HashMap<>();

    private final PremiumUserDataToPremiumUser premiumUserDataToPremiumUser;
    private final PremiumUserToPremiumUserData premiumUserToPremiumUserData;

    public PremiumUserRepositoryInMemoryImpl(PremiumUserDataToPremiumUser premiumUserDataToPremiumUser, PremiumUserToPremiumUserData premiumUserToPremiumUserData) {
        this.premiumUserDataToPremiumUser = premiumUserDataToPremiumUser;
        this.premiumUserToPremiumUserData = premiumUserToPremiumUserData;
    }


    @Override
    public PremiumUser save(PremiumUser premiumUser) {
        final String id = IdGenerator.generateId();
        var userData = this.premiumUserToPremiumUserData.convert(premiumUser);

        final var newUser =  userData.cloneWithId(id);

         userMap.put(id, newUser);
         return premiumUser.cloneWithId(id);
    }

    @Override
    public void update(PremiumUser premiumUser) { ;
         userMap.put(premiumUser.getId(), this.premiumUserToPremiumUserData.convert(premiumUser));
    }

    @Override
    public void deleteById(String id) {
            userMap.remove(id);
    }

    @Override
    public PremiumUser findById(String id) {
        return this.premiumUserDataToPremiumUser.convert(userMap.get(id));
    }

    @Override
    public List<PremiumUser> findAll() {
        return userMap.values().stream().map(premiumUserDataToPremiumUser::convert).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public PremiumUser findByUsername(String username) {
        return userMap.values().stream()
                      .map(premiumUserDataToPremiumUser::convert)
                      .filter(premiumUser -> premiumUser.getUsername().equals(username))
                      .findFirst()
                      .orElse(null);
    }
}
