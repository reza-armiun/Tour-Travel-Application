package razarm.tosan.security.services;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import razarm.tosan.security.model.Session;
import razarm.tosan.security.repository.SessionRepository;

import javax.crypto.SecretKey;

@AllArgsConstructor
@Service
public class SessionServiceImpl implements SessionService {
    private final SessionRepository userSessionRepository;
    private final SecretKey secretKey;


    @Override
    public Session findSessionByUsername(String username)  {
        return this.userSessionRepository.findByUsername(username);
    }

    @Override
    public boolean isSessionValid(String username, String token)  {
        if(username == null || token == null )return false;

        final Session session = this.userSessionRepository.findByUsername(username);
        if(session.getToken().equals(token)) return true;
        else return false;
    }

    @Override
    public boolean isTokenValid(String token)  {
//        String tokenSlice = token.substring(7);

        Jws<Claims> claimsJws =
                Jwts.parserBuilder()
                        .setSigningKey(secretKey)
                        .build()
                        .parseClaimsJws(token);

        Claims body = claimsJws.getBody();

        String username = body.getSubject();

        if (!this.isSessionValid(username, token)) {
            return false;
        }
        return true;

    }

    @Override
    public void insertSession(Session userSession) {
        if (userSession != null) {
//            this.userSessionRepository.findById(userSession.getUsername()).ifPresent(sessionUser1 -> this.sessionUserRepository.deleteById(sessionUser1.getUsername()));
            this.userSessionRepository.saveSession(new Session(userSession.getUsername(), userSession.getToken()));
        }
    }

    @Override
    public void removeSession(String username) {
        if (username != null) this.userSessionRepository.removeByUsername(username);
    }

    @Override
    public void removeToken(String token) {
        if(token != null) this.userSessionRepository.removeByToken(token);
    }

}