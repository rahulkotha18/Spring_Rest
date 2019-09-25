package tasks.todo.pojo;

public class UserPojo
{
    String username;
    String password;

    public UserPojo(){}
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

    public UserPojo(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
