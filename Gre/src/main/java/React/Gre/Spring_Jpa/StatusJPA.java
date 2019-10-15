package React.Gre.Spring_Jpa;

import React.Gre.Entity.Status;
import React.Gre.Entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusJPA extends JpaRepository<Status,Integer> {
    Optional<Status> findByTokenid(Token token);
}
