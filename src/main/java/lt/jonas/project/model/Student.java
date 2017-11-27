package lt.jonas.project.model;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {
    private long id;
    private String name;
    private String surname;
    private User1 user1;
    private Class1 class1;
    private Foster foster;

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

    @OneToOne(cascade = CascadeType.ALL)
    public User1 getUser1() {
        return user1;
    }

    public void setUser1(User1 user1) {
        this.user1 = user1;
    }


    @ManyToOne
    public Class1 getClass1() {
        return class1;
    }

    public void setClass1(Class1 class1) {
        this.class1 = class1;
    }

    @ManyToOne
    public Foster getFoster() {
        return foster;
    }

    public void setFoster(Foster foster) {
        this.foster = foster;
    }
}
