package lt.jonas.project.service;

import lt.jonas.project.model.SubjectList;
import lt.jonas.project.repository.SubjectListRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectListServiceImpl implements SubjectListService {
    @Autowired
    SubjectListRep subjectListRep;

    @Override
    public void addSubjectList(SubjectList subjectList) {
        subjectListRep.save(subjectList);
    }

    @Override
    public List<SubjectList> findAll() {
        return subjectListRep.findAll();
    }

    @Override
    public void deleteSubjectListById(long id) {
        subjectListRep.delete(id);
    }


}
