package com.spring.todoapp.repositories;

import com.spring.todoapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPA extends JpaRepository<User,Integer> {
}
