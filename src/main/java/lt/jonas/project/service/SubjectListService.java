package lt.jonas.project.service;

import lt.jonas.project.model.SubjectList;

import java.util.List;

public interface SubjectListService {
    void addSubjectList(SubjectList subjectList);
    List<SubjectList> findAll();
    void deleteSubjectListById(long id);
    
}
