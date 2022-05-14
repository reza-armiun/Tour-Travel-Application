package razarm.tosan.repository.inMemoryImpl.auth;

import razarm.tosan.repository.data.auth.UserSessionData;
import razarm.tosan.repository.domain.auth.UserSession;
import razarm.tosan.repository.UserSessionRepository;
import razarm.tosan.repository.mapper.auth.UserSessionDataToUserSession;
import razarm.tosan.repository.mapper.auth.UserSessionToUserSessionData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserSessionRepositoryInMemoryImpl implements UserSessionRepository {
    private Map<String , UserSessionData> userSessions= new HashMap<>();

    private final UserSessionDataToUserSession toUser;
    private final UserSessionToUserSessionData toData;

    public UserSessionRepositoryInMemoryImpl(UserSessionDataToUserSession toUser, UserSessionToUserSessionData toData) {
        this.toUser = toUser;
        this.toData = toData;
    }

    @Override
    public UserSession save(UserSession userSession) {
        this.userSessions.put(userSession.getUsername(), this.toData.convert(userSession));
        return userSession;
    }

    @Override
    public void update(UserSession userSession) {
        this.userSessions.put(userSession.getUsername(), this.toData.convert(userSession));
    }

    @Override
    public void deleteById(String s) {
        this.userSessions.remove(s);
    }

    @Override
    public UserSession findById(String s) {
        return this.toUser.convert(userSessions.get(s));
    }

    @Override
    public List<UserSession> findAll() {
        return userSessions.values().stream().map(toUser::convert).collect(Collectors.toUnmodifiableList());
    }

}
