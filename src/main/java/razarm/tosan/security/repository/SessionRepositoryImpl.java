package razarm.tosan.security.repository;

import org.springframework.stereotype.Repository;
import razarm.tosan.security.model.Session;

import java.util.HashMap;
import java.util.Map;


@Repository
public class SessionRepositoryImpl implements SessionRepository{
    private final Map<String, Session>  sessionMap=  new HashMap();
    @Override
    public Session saveSession(Session session) {
        return this.sessionMap.put(session.getUsername(), session);
    }

    @Override
    public Session findByUsername(String username) {
        return sessionMap.get(username);
    }

    @Override
    public void removeByUsername(String username) {
         sessionMap.remove(username);
    }

    @Override
    public void removeByToken(String token) {
        var session = sessionMap.values().stream()
                .filter(se -> se.getToken().equals(token)).findFirst().orElse(null);
        if(session != null){
            sessionMap.remove(session.getUsername());
        }
    }
}
