package React.Gre.Spring_Jpa;

import React.Gre.Entity.Words;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordsRepository extends JpaRepository<Words,Integer> {
}