package lt.jonas.project.repository;

import lt.jonas.project.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRep extends JpaRepository<Teacher, Long> {

}
