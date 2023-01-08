package be.helb.DAO;

import be.helb.model.Workout;
import be.helb.model.Workout_Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Workout_ExerciseDao  extends JpaRepository<Workout_Exercise, Long> {
    List<Workout_Exercise> findWorkout_ExercisesByWorkout(Workout workout);
}

