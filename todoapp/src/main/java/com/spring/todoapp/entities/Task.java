package com.spring.todoapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @Column(name = "id")
    private int u_id;
    @Column(name = "task_name")
    private String task_name;
    @Column(name = "description")
    private  String description;
    public Task(){}

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
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

    public Task(int u_id, String task_name, String description) {
        this.u_id = u_id;
        this.task_name = task_name;
        this.description = description;
    }
}
