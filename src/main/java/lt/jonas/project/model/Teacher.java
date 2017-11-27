package lt.jonas.project.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="teacher")
public class Teacher {
    private long id;
    private String name;
    private String surname;
    private String telephone;
    private String email;
    private String class_name;
//    private User1 user1;
    private List<Subject> subjectList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

//    @OneToOne(cascade = CascadeType.REMOVE)
//    public User1 getUser1() {
//        return user1;
//    }
//
//    public void setUser1(User1 user1) {
//        this.user1 = user1;
//    }

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.REFRESH)
    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }
}
