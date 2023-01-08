package be.helb.controller;

import be.helb.DAO.UserDao;
import be.helb.DAO.WorkoutDao;
import be.helb.model.Workout;
import be.helb.service.WorkoutService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/api/Workout")
@RestController
public class WorkoutController {

    private WorkoutService workoutService;
    @Autowired
    private UserDao userDao;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping("/All")
    @ApiOperation(value = "Get all existing workouts")
    public List<Workout> getAllWorkout() {
        return workoutService.getAllWorkout();
    }

    @GetMapping("/My Workout")
    @ApiOperation(value = "Get all your workouts")
    public List<Workout> getMyWorkout() {
        String user = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return workoutService.getWorkoutByAuthor(user);
    }

    @PostMapping("/New")
    @ApiOperation(value = "Create a new workout")
    public ResponseEntity<Workout> newWorkout(@RequestParam String name) {
        return ResponseEntity.ok(workoutService.createWorkout(name));
    }


    @DeleteMapping("/Delete/{id}")
    @ApiOperation(value = "Delete a workout")
    public  ResponseEntity<Workout> deleteWorkout(@PathVariable Long id) {
        if (workoutService.deleteWorkoutById(id)){
            return new ResponseEntity<Workout>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Workout>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/Update/{id}")
    @ApiOperation(value = "Update a workout")
    public ResponseEntity<Workout> updateWorkout(@PathVariable Long id, @RequestParam String name) {
        if (workoutService.updateWorkoutName(id, name)){
            return new ResponseEntity<Workout>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Workout>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
