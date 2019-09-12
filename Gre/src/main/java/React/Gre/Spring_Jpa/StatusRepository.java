package React.Gre.Spring_Jpa;

import React.Gre.Entity.Status;
import React.Gre.Entity.token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusRepository  extends JpaRepository<Status,Integer> {
    Optional<Status> findByTokenid(token token);
}
