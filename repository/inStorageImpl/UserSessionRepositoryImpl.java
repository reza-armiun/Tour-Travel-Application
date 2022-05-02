package razarm.tosan.repository.inStorageImpl;

import razarm.tosan.repository.UserSessionRepository;
import razarm.tosan.repository.domain.auth.UserSession;
import razarm.tosan.repository.mapper.auth.UserSessionDataToUserSession;
import razarm.tosan.repository.mapper.auth.UserSessionToUserSessionData;

import java.util.List;

public class UserSessionRepositoryImpl implements UserSessionRepository {
    private final UserSessionDataToUserSession toUser;
    private final UserSessionToUserSessionData toData;

    public UserSessionRepositoryImpl(UserSessionDataToUserSession toUser, UserSessionToUserSessionData toData) {
        this.toUser = toUser;
        this.toData = toData;
    }

    @Override
    public UserSession save(UserSession userSession) {
        return null;
    }

    @Override
    public void update(UserSession userSession) {

    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public UserSession findById(String s) {
        return null;
    }

    @Override
    public List<UserSession> findAll() {
        return null;
    }
}
