package lt.jonas.project.repository;


import lt.jonas.project.model.User1;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ramunas on 02/10/2017.
 */
public interface UserRep extends JpaRepository<User1, Long> {
    User1 findByUsername(String username);
}
