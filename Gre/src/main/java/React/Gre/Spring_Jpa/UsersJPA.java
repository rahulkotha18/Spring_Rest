package React.Gre.Spring_Jpa;

import React.Gre.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersJPA extends JpaRepository<Users,Integer> {
}