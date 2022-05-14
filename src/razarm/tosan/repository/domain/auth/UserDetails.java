package razarm.tosan.repository.domain.auth;

import java.util.Collection;

public interface UserDetails {
        String getUsername();
        String getPassword();
        Collection<? extends  Authority> getAuthorities();
        boolean isAccountNonExpired();
        boolean	isAccountNonLocked();
        boolean isCredentialsNonExpired();
        boolean isEnabled();

}
