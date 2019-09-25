package com.spring.todoapp.repositories;

import com.spring.todoapp.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskJPA extends JpaRepository<Task,Integer> {
}
