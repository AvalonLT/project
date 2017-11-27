package lt.jonas.project.service;


import lt.jonas.project.model.User1;
import lt.jonas.project.repository.RoleRep;
import lt.jonas.project.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRep userRep;
    @Autowired
    RoleRep roleRep;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User1 user1) {
        user1.setPassword(bCryptPasswordEncoder.encode(user1.getPassword()));  // reikia sifruoti
        user1.setRole(user1.getRole());
//        user1.setRole(new HashSet<>(roleRep.findAll()));
        userRep.save(user1);

    }

    @Override
    public User1 findByUsername(String username) {
        return userRep.findByUsername(username);
    }
}
