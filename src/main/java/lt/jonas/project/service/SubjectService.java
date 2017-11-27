package lt.jonas.project.service;

import lt.jonas.project.model.Subject;

import java.util.List;

public interface SubjectService {
    void updateSubjectById(Subject subject);
    void updateSubjectListByTeacher(List<Subject> subjectList);
    List<Subject> findAllSubjectsByTeacherId(long id);
    void deleteAllSubjects(List<Subject> subjectList);
}
