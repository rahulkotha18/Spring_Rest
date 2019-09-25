package tasks.todo.pojo;

import java.util.Date;

public class ReqPost
{
    int user;
    int task;
    Date date;
    public ReqPost(){}

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getTask() {
        return task;
    }

    public void setTask(int task) {
        this.task = task;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ReqPost(int user, int task, Date date) {
        this.user = user;
        this.task = task;
        this.date = date;
    }
}
