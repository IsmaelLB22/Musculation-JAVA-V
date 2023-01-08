package be.helb.controller;

import be.helb.DAO.ExerciseDao;
import be.helb.model.Exercise;
import be.helb.model.Workout;
import be.helb.service.ExerciseService;
import be.helb.service.WorkoutService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Exercise")
public class ExerciseController {
    private ExerciseService exerciseService;


    public ExerciseController(ExerciseService exerciseService){
        this.exerciseService = exerciseService;
    }

    @GetMapping("/Search")
    @ApiOperation(value = "Search an existing exercises")
    public List<Exercise> searchExercise(@RequestParam String name){
        return exerciseService.getSearchedExercises(name);
    }

    @GetMapping("/All")
    @ApiOperation(value = "Get all existing exercises")
    public List<Exercise> getAllExercises(){
        return exerciseService.getAllExercises();
    }

    @PostMapping("/New")
    @ApiOperation(value = "Create a new exercise")
    public void newExercise(@RequestParam String name,@RequestParam String description) {
        exerciseService.createExercise(name, description);
    }

    @DeleteMapping("/Delete/{id}")
    @ApiOperation(value = "Delete an exercise")
    public  void deleteWorkout(@PathVariable Long id) {
        exerciseService.deleteExerciseById(id);
    }

    @PutMapping("/Update/{id}")
    @ApiOperation(value = "Update an exercise's name & description")
    public void updateExercise(@PathVariable Long id, @RequestParam String name,@RequestParam String description) {
       exerciseService.updateExercise(id, name, description);
    }
}
