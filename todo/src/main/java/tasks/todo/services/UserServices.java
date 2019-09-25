package tasks.todo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tasks.todo.RepositoryJPA.UserJPA;
import tasks.todo.entities.User;

import java.util.List;

@Service
public class UserServices
{
    @Autowired
    UserJPA userJPA;
    public int getUserId(String username,String password)
    {
        List<User> userList=userJPA.findAll();
        for(User user:userList)
        {
            if(user.getUsername().equals(username)&&user.getPassword().equals(password))
            {
                return user.getId();
            }
        }
        return -1;
    }
    public List<User> getAllUsers()
    {
        return userJPA.findAll();
    }
}
