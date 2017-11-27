package lt.jonas.project.util;

import lt.jonas.project.model.Subject;
import lt.jonas.project.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherUtil {

    public List<Subject> makeSubjectList(String subjectList, Teacher teacher) {
        subjectList.trim();
        String[] subjectNames = subjectList.split(" ");
        List<Subject> subjectList1 = new ArrayList<>();
        for (String subjectName : subjectNames) {
            Subject subject = new Subject();
            subject.setName(subjectName);
            subject.setTeacher(teacher);
            subjectList1.add(subject);
        }
        return subjectList1;
    }


}
