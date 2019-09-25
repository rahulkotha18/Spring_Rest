package tasks.todo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "task_name")
    private String task_name;
    @Column(name = "description")
    private  String description;
    @JsonIgnore
    @OneToMany(mappedBy = "task",cascade=CascadeType.ALL)
    private List<Assign> list;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Assign> getList() {
        return list;
    }

    public void setList(List<Assign> list) {
        this.list = list;
    }

    public Task(int id, String task_name, String description, List<Assign> list) {
        this.id = id;
        this.task_name = task_name;
        this.description = description;
        this.list = list;
    }

    public Task(){}
}
