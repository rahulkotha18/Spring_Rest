package tasks.todo.RepositoryJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import tasks.todo.entities.User;

public interface UserJPA extends JpaRepository<User,Integer> {
}
