package tasks.todo.RepositoryJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import tasks.todo.entities.Task;

public interface TaskJPA extends JpaRepository<Task,Integer> {
}
