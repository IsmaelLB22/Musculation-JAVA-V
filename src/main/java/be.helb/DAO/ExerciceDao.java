package be.helb.DAO;

import be.helb.model.Exercice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciceDao extends JpaRepository<Exercice, Long> {

    List<Exercice> findByName(String name);
}
