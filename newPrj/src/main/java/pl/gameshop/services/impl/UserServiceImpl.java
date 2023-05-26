package pl.gameshop.services.impl;

import com.bryghts.ftypes.async.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gameshop.models.Role;
import pl.gameshop.repositories.RoleRepository;
import pl.gameshop.repositories.UserRepository;
import pl.gameshop.services.UserService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    //bez adnotacji @Transactional sesja jest zamykana po wywołaniu findByUsername, co uniemożliwia dociągnięcie ról, gdyż fetch=EAGER.
    //ponadto, musi być włączone zarządzanie transakcjami @EnableTransactionManagement
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        pl.gameshop.models.User user = userRepository.findByUsername(username.toString());
        if (user == null) {
            throw new UsernameNotFoundException(username.toString());
        }

        return createUserDetails(user);
    }

    private UserDetails createUserDetails(pl.gameshop.models.User user) {
        Set<GrantedAuthority> grantedAuthorities =
                user.getRoles().stream().map(//mapowanie Role na GrantedAuthority
                        r -> new SimpleGrantedAuthority(r.getType().toString())
                ).collect(Collectors.toSet());

        return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, grantedAuthorities);
    }

    @Override
    public void save(pl.gameshop.models.User user) {

        Role userRole = roleRepository.findRoleByType(Role.Types.ROLE_USER);
        List roles = Arrays.asList(userRole);
        user.setRoles(new HashSet<>(roles));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setPasswordConfirm(null);//wyzerowanie jest potrzebne ze względu na walidację
        userRepository.saveAndFlush(user);
    }

    @Override
    public boolean isUniqueLogin(String username) {
        return userRepository.findByUsername(username.toString()) == null;
    }
    @Override
    public boolean isUniqueEmail(String email) {
        return userRepository.findByEmail(email.toString()) == null;
    }

    @Override
    public UserDetails loadUserByUsername(java.lang.String s) throws UsernameNotFoundException {
        return null;
    }
}
