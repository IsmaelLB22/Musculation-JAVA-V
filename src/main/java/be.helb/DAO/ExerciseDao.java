package be.helb.DAO;

import be.helb.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseDao extends JpaRepository<Exercise, Long> {

    List<Exercise> findByName(String name);

    Exercise getExerciseById(Long exerciseId);
}
