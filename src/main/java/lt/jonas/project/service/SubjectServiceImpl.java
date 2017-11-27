package lt.jonas.project.service;

import lt.jonas.project.model.Subject;
import lt.jonas.project.repository.SubjectRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    SubjectRep subjectRep;

    @Override
    public void updateSubjectById(Subject subject) {
        subjectRep.save(subject);
    }

    @Override
    public List<Subject> findAllSubjectsByTeacherId(long id) {
        return subjectRep.findAllByTeacher_Id(id);
    }

    @Override
    public void deleteAllSubjects(List<Subject> subjectList) {
        subjectRep.delete(subjectList);
    }

    @Override
    public void updateSubjectListByTeacher(List<Subject> subjectList) {
        ArrayList<Subject> arrayList = new ArrayList<>();
        subjectRep.save(subjectList);
    }
}


