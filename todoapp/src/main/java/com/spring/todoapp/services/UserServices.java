package com.spring.todoapp.services;

import com.spring.todoapp.entities.Task;
import com.spring.todoapp.entities.User;
import com.spring.todoapp.repositories.TaskJPA;
import com.spring.todoapp.repositories.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {
    @Autowired
    UserJPA userjpa;
    @Autowired
    TaskJPA taskjpa;
    public List<User> getUsers()
    {
        return userjpa.findAll();
    }

    public String getUserTasks()
    {
        User user=userjpa.findById(1).get();
        return user.getTaskLists().toString();
    }
    public List<Task> getTasks()
    {
        return taskjpa.findAll();
    }

}
