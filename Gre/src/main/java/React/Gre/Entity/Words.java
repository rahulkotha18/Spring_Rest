package React.Gre.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@JsonIgnoreProperties
@Entity
@Table(name = "words")
public class Words {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "word")
    private String word;
    @Column(name = "meaning")
    private String meaning;
    public Words()
    {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public Words(int id, String word, String meaning) {
        this.id = id;
        this.word = word;
        this.meaning = meaning;
    }
    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "status",
            joinColumns = {@JoinColumn(name = "w_id")},
            inverseJoinColumns = {@JoinColumn(name = "u_id")}
    )
    private List<Users> users = new ArrayList<>();

    public List<Users> getUsers() {
        return users;
    }
}

