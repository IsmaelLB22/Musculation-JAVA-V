package be.helb.controller;

import be.helb.DAO.Workout_ExerciseDao;
import be.helb.model.Workout_Exercise;
import be.helb.service.Workout_ExerciseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Workout_Exercise")
public class Workout_ExerciseController {
    private Workout_ExerciseService workout_exerciseService;

    public Workout_ExerciseController(Workout_ExerciseService workout_exerciseService) {
        this.workout_exerciseService = workout_exerciseService;
    }

    @GetMapping("/All")
    @ApiOperation(value = "Get all workouts")
    public List<Workout_Exercise> getAllWorkout() {
        return workout_exerciseService.getAllWorkout_Exercice();
    }

    @GetMapping("/Workout_exercise/{id}")
    @ApiOperation(value = "Get all added exercises to a workout")
    public List<Workout_Exercise> getAllWorkoutByWorkoutId(@PathVariable Long id) {
        return workout_exerciseService.getCompleteWorkoutById(id);
    }

    @PostMapping("/Add exercise to workout")
    @ApiOperation(value = "Add exercise to a workout and specify series & repetitions")
    public  void   addExerciseToWorkout(@RequestParam Long workoutId, @RequestParam Long exerciseId, @RequestParam int series, @RequestParam int repetitions) {
        workout_exerciseService.addExercise(workoutId, exerciseId, series, repetitions);
    }

    @PutMapping("/Update/{id}")
    @ApiOperation(value = "Update an exercise's series & repetitions")
    public void updateWorkout(@RequestBody Workout_Exercise workoutExercise) {
        //workout_exerciseService.save(workoutExercise);
    }

}