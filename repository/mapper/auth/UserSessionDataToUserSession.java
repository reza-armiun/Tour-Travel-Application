package razarm.tosan.repository.mapper.auth;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.auth.UserSessionData;
import razarm.tosan.repository.domain.auth.UserSession;

public class UserSessionDataToUserSession implements Mapper<UserSessionData, UserSession> {
    @Override
    public UserSession convert(UserSessionData userSessionData) {
        return UserSession.UserSessionBuilder.anUserSession()
                                             .username(userSessionData.getUsername())
                                             .sessionId(userSessionData.getSessionId())
                                             .createdAt(userSessionData.getCreatedAt())
                                             .build();
    }
}
