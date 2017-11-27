package lt.jonas.project.repository;


import lt.jonas.project.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ramunas on 02/10/2017.
 */
public interface RoleRep extends JpaRepository<Role, Long> {
}
