package React.Gre.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.List;
@JsonIgnoreProperties
@Entity
@Table(name = "users")
public class Users {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    public Users()
    {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "status",
            joinColumns ={ @JoinColumn(name = "u_id")},
            inverseJoinColumns = {@JoinColumn(name = "w_id")}
    )
    private List<Words> words;

    public List<Words> getWords() {
        return words;
    }
}
