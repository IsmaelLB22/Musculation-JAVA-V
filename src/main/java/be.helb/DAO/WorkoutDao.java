package be.helb.DAO;

import be.helb.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WorkoutDao  extends JpaRepository<Workout, Long> {
    Workout findByName(String name);
    Optional<Workout> findById(Long id);
    List<Workout> findAllByAuthor(String author);
    Workout findByAuthor(String author);

    Workout getWorkoutById(Long workoutId);
}
