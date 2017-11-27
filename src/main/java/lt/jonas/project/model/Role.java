package lt.jonas.project.model;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="role")
public class Role  {
    private Long id;
    private String name;
    private List<User1> user1s;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    public List<User1> getUser1s() {
        return user1s;
    }

    public void setUser1s(List<User1> user1s) {
        this.user1s = user1s;
    }
}
