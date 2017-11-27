package lt.jonas.project.service;

import lt.jonas.project.model.Class1;
import lt.jonas.project.model.Foster;
import lt.jonas.project.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudentList();
    void deleteStudent(long id);
    Class1 addClass1WithNameAndReturnObjectWithId(String class1Name);
    Foster addFosterWithAddressAndReturnObjectWithId(String address);
    void addStudent(Student student, Foster foster, Class1 class1);
    Class1 updateClass1(long ClassId, String name);
    Foster updateFoster(long fosterId, String parentInfo);
    void updateStudent(long studentId, Student student, Foster foster, Class1 class1);
    Foster getFosterById(long fosterId);
}
