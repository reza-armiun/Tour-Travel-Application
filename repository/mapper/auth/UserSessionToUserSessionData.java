package razarm.tosan.repository.mapper.auth;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.auth.UserSessionData;
import razarm.tosan.repository.domain.auth.UserSession;

public class UserSessionToUserSessionData implements Mapper<UserSession, UserSessionData> {
    @Override
    public UserSessionData convert(UserSession userSession) {
        return UserSessionData.UserSessionDataBuilder.anUserSessionData()
                                                     .username(userSession.getUsername())
                                                     .sessionId(userSession.getSessionId())
                                                     .createdAt(userSession.getCreatedAt())
                                                     .build();
    }
}
