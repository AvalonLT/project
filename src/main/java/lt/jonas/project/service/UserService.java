package lt.jonas.project.service;


import lt.jonas.project.model.User1;

/**
 * Created by ramunas on 02/10/2017.
 */
public interface UserService {
    void save(User1 user1);
    User1 findByUsername(String username);
}
