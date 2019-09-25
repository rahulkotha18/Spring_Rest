package tasks.todo.dao;
import org.hibernate.Session;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tasks.todo.entities.Task;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TaskListDao
{
    @Autowired
    EntityManager entityManager;
//    public List<Task> getTaskOfUser(int user_id)
//    {
//
//    }
}