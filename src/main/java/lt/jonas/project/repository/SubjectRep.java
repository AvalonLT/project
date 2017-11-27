package lt.jonas.project.repository;

import lt.jonas.project.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRep extends JpaRepository<Subject, Long> {
    List<Subject> findAllByTeacher_Id(long teacherId);


}
