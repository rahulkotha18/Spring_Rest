package tasks.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tasks.todo.entities.Assign;
import tasks.todo.entities.Task;
import tasks.todo.entities.User;
import tasks.todo.pojo.ReqPost;
import tasks.todo.pojo.UserPojo;
import tasks.todo.services.TaskServices;
import tasks.todo.services.UserServices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class TaskController
{
    @Autowired
    TaskServices taskServices;
    @Autowired
    UserServices userServices;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAll")
    public List<Task> getAll()
    {
        return taskServices.getAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getTasks/{id}")
    public List<Assign> getTasks(@PathVariable int id)
    {
        return taskServices.getTasks(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllUsers")
    public List<User> getUsers(){return userServices.getAllUsers();}

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/auth")
    public int authUser(@RequestBody UserPojo user)
    {

        return userServices.getUserId(user.getUsername(),user.getPassword());
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addTask")
    public Task addTask(@RequestBody Task task)
    {

        return taskServices.saveTask(task);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/assignTask")
    public boolean assignTask(@RequestBody ReqPost reqPost)
    {

        return taskServices.assignTask(reqPost);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/unassignTask")
    public int unassignTask(@RequestBody Assign assign)
    {

        return taskServices.unassignTask(assign);
    }

}
