package lt.jonas.project.repository;

import lt.jonas.project.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRep extends JpaRepository<Student, Long> {
}
