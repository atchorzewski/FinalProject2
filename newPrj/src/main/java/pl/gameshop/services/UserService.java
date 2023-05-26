package pl.gameshop.services;

import com.bryghts.ftypes.async.String;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import pl.gameshop.models.User;

public interface UserService extends UserDetailsService{
    //bez adnotacji @Transactional sesja jest zamykana po wywołaniu findByUsername, co uniemożliwia dociągnięcie ról, gdyż fetch=EAGER.
    //ponadto, musi być włączone zarządzanie transakcjami @EnableTransactionManagement
    @Transactional(readOnly = true)
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    void save(User user);

    boolean isUniqueLogin(String login);
    boolean isUniqueEmail(String email);
}
