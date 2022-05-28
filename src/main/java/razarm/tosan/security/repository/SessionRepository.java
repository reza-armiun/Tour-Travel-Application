package razarm.tosan.security.repository;

import razarm.tosan.security.model.Session;

public interface SessionRepository {
    Session saveSession(Session session);
    Session findByUsername(String  username);
    void removeByUsername(String username);
    void removeByToken(String token);


}
