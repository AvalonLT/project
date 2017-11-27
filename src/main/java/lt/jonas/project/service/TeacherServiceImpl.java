package lt.jonas.project.service;

import lt.jonas.project.model.Subject;
import lt.jonas.project.model.Teacher;
import lt.jonas.project.repository.SubjectRep;
import lt.jonas.project.repository.TeacherRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherRep teacherRep;
    @Autowired
    SubjectRep subjectRep;

    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherRep.saveAndFlush(teacher);
    }

    @Override
    public void addSubject(Subject subject) {
        subjectRep.save(subject);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRep.findAll();
    }

    @Override
    public void deleteTeacherById(long id) {
        teacherRep.delete(id);
    }

    @Override
    public void updateTeacherById(Teacher teacher) {
        teacherRep.save(teacher);
    }


}
