package tasks.todo.RepositoryJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import tasks.todo.entities.Assign;

public interface AssignJPA extends JpaRepository<Assign,Integer> {
}
