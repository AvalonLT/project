package lt.jonas.project.repository;

import lt.jonas.project.model.SubjectList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectListRep extends JpaRepository<SubjectList, Long> {
}
