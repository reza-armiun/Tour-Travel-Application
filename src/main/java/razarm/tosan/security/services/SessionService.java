package razarm.tosan.security.services;


import razarm.tosan.security.model.Session;

public interface SessionService {
    Session findSessionByUsername(String username) ;
    boolean isSessionValid(String username,String token) ;
    boolean  isTokenValid(String token) ;
    void insertSession(Session session);
    void removeSession(String username);
    void removeToken(String token);

}