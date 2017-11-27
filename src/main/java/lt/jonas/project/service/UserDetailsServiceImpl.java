package lt.jonas.project.service;
import lt.jonas.project.model.User1;
import lt.jonas.project.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


@Service   //cia buvo taisyta
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRep userRep;


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User1 user1 = userRep.findByUsername(s);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        grantedAuthorities.add(new SimpleGrantedAuthority(user1.getRole().getName()));
        grantedAuthorities.add(new SimpleGrantedAuthority("admin"));
//        for (Role role : user1.getRole()){
//            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
//        }

        return new org.springframework.security.core.userdetails.User(user1.getUsername(), user1.getPassword(), grantedAuthorities) {
        };
    }
}
