package lt.jonas.project.util;

import lt.jonas.project.model.Class1;
import lt.jonas.project.model.Foster;
import lt.jonas.project.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentUtil {
    public Class1 createClass1WithNameAndStudentId(long studentId, String class1Name) {
        Class1 newClass = new Class1();
        newClass.setName(class1Name);
        newClass.setId(studentId);
        return newClass;
    }

    public Foster createFosterWithAddressAndStudentId(Student student, String fosterAddress) {
        Foster foster = new Foster();
        foster.setAddress(fosterAddress);
        List<Student> fosterList = new ArrayList<>();
        fosterList.add(student);
        foster.setStudentList(fosterList);
        return foster;
    }


}
