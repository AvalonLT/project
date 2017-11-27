package lt.jonas.project.service;

import lt.jonas.project.model.Class1;
import lt.jonas.project.model.Foster;
import lt.jonas.project.model.Student;
import lt.jonas.project.repository.Class1Rep;
import lt.jonas.project.repository.FosterRep;
import lt.jonas.project.repository.StudentRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRep studentRep;
    @Autowired
    FosterRep fosterRep;
    @Autowired
    Class1Rep class1Rep;

    @Override
    public List<Student> getStudentList() {
        return studentRep.findAll();
    }

    @Override
    public void deleteStudent(long id) {
        studentRep.delete(id);
    }

    @Override
    public Class1 addClass1WithNameAndReturnObjectWithId(String class1Name) {
        Class1 class1 = new Class1();
        class1.setName(class1Name);
        return class1Rep.saveAndFlush(class1);
    }

    @Override
    public Foster addFosterWithAddressAndReturnObjectWithId(String address) {
        Foster foster = new Foster();
        foster.setAddress(address);
        return fosterRep.saveAndFlush(foster);
    }

    @Override
    public void addStudent(Student student, Foster foster, Class1 class1) {
        student.setFoster(foster);
        student.setClass1(class1);
        studentRep.save(student);
    }

    @Override
    public Class1 updateClass1(long classId, String name) {
        Class1 class1 = new Class1();
        class1.setName(name);
        class1.setId(classId);
        return class1Rep.saveAndFlush(class1);
    }

    @Override
    public Foster updateFoster(long fosterId, String parentInfo) {
        Foster foster = getFosterById(fosterId);
        foster.setAddress(parentInfo);
        return fosterRep.saveAndFlush(foster);
    }

    @Override
    public void updateStudent(long studentId, Student student, Foster foster, Class1 class1) {
        student.setId(studentId);
        student.setClass1(class1);
        student.setFoster(foster);
        studentRep.save(student);
    }

    @Override
    public Foster getFosterById(long fosterId) {
        return fosterRep.getOne(fosterId);
    }
}
