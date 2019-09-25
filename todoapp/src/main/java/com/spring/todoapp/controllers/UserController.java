package com.spring.todoapp.controllers;

import com.spring.todoapp.entities.Task;
import com.spring.todoapp.entities.User;
import com.spring.todoapp.services.TaskServices;
import com.spring.todoapp.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController
{
    @Autowired
    UserServices userServices;
    @Autowired
    TaskServices taskServices;
    @GetMapping("users")
    public List<User> getUsers()
    {
        return  userServices.getUsers();
    }
    @GetMapping("tasks")
    public List<Task> getTasks()
    {
        return  userServices.getTasks();
    }
    @GetMapping("/user/tasks")
    public String  getUserTasks()
    {
        return  userServices.getUserTasks();
    }

}
