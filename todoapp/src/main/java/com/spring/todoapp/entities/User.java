package com.spring.todoapp.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int u_id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private  String last_name;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "user_id",cascade = CascadeType.ALL)
    private Set<TaskList> taskLists;
    public User(){}

    public User(int u_id, String first_name, String last_name, String username, String password, Set<TaskList> taskLists) {
        this.u_id = u_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
        this.taskLists = taskLists;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<TaskList> getTaskLists() {
        return taskLists;
    }

    public void setTaskLists(Set<TaskList> taskLists) {
        this.taskLists = taskLists;
    }
}
