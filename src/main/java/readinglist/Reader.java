package readinglist;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by 이민규 on 2016-12-21.
 */
@Entity
@Data
public class Reader implements UserDetails {

    @Id // Reader 필드
    private String username;
    private String fullname;
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // READER 권한 부여
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_READER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() { // 계정이 만료되지 않았다는 것을 반환
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { // 계정이 잠겨 있지 않았다는 것을 반환
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { // 자격이 유효하다는 것을 반환
        return true;
    }

    @Override
    public boolean isEnabled() { // 계정이 활성화되어 있다는 것을 반환
        return false;
    }
}
