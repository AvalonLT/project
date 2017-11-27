package lt.jonas.project.service;

import lt.jonas.project.model.Subject;
import lt.jonas.project.model.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher addTeacher(Teacher teacher);
    void addSubject(Subject subject);
    List<Teacher> findAll();
    void deleteTeacherById(long id);
    void updateTeacherById(Teacher teacher);
}
