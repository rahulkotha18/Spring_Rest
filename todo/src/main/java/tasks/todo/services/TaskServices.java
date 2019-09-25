package tasks.todo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tasks.todo.RepositoryJPA.AssignJPA;
import tasks.todo.RepositoryJPA.TaskJPA;
import tasks.todo.RepositoryJPA.UserJPA;
import tasks.todo.entities.Assign;
import tasks.todo.entities.Task;
import tasks.todo.entities.User;
import tasks.todo.pojo.ReqPost;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServices
{
    @Autowired
    TaskJPA taskJPA;
    @Autowired
    UserJPA userJPA;
    @Autowired
    AssignJPA assignJPA;
    public List<Task> getAll()
    {
        return taskJPA.findAll();
    }
    public Task saveTask(Task task)
    {
        taskJPA.save(task);
        return task;
    }
    public List<Assign> getTasks(int id)
    {
        System.out.println(userJPA.findById(id).get().getList().toArray());

        List<Assign> assignList= userJPA.findById(id).get().getList();
        return assignList;
    }
    public boolean assignTask(ReqPost reqPost)
    {
        User user=userJPA.findById(reqPost.getUser()).get();
        Task task=taskJPA.findById(reqPost.getTask()).get();
        List<Assign> list=user.getList();
        Assign assign=new Assign();
        assign.setTask(task);
        assign.setUser(user);
        assign.setDue(reqPost.getDate());
        assignJPA.save(assign);
        list.add(assign);
        return true;
    }
    public int unassignTask(Assign assign)
    {
        assignJPA.delete(assign);
        return  1;
    }
}
