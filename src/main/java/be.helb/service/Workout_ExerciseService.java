package be.helb.service;

import be.helb.DAO.ExerciseDao;
import be.helb.DAO.UserDao;
import be.helb.DAO.WorkoutDao;
import be.helb.DAO.Workout_ExerciseDao;
import be.helb.model.Exercise;
import be.helb.model.User;
import be.helb.model.Workout;
import be.helb.model.Workout_Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class Workout_ExerciseService {
    @Autowired
    private Workout_ExerciseDao workoutExerciseDao;
    @Autowired
    private ExerciseDao exerciseDao;
    @Autowired
    private WorkoutDao workoutDao;
    @Autowired
    private UserDao userDao;

    public Workout_ExerciseService(Workout_ExerciseDao workoutExerciseDao) {
        this.workoutExerciseDao = workoutExerciseDao;
    }

    public List<Workout_Exercise> getAllWorkout_Exercice(){
        List<Workout_Exercise> workout_exerciceList = workoutExerciseDao.findAll();
        return workout_exerciceList;
    }


    public List<Workout> getWorkout_ExerciseByAuthor(String user) {
        return workoutDao.findAllByAuthor(user);
    }


    public Boolean updateWorkoutName(Long workoutId, String name) {
        String author = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findByUsername(author);
        Workout workout = workoutDao.getWorkoutById(workoutId);
        if (user.getId() == workout.getUser().getId() && workout != null){
            workout.setName(name);
            workoutDao.save(workout);
            return true;
        } else {
            return false;
        }
    }

    public Boolean deleteWorkoutById(Long workoutId) {
        String author = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findByUsername(author);
        Workout workout = workoutDao.getWorkoutById(workoutId);
        if (user.getId() == workout.getUser().getId() && workout != null){
            workoutDao.deleteById(workoutId);
            return true;
        } else {
            return false;
        }
    }

    public List<Workout_Exercise> getCompleteWorkoutById(Long workoutId) {
        Workout workout = workoutDao.getWorkoutById(workoutId);
        List<Workout_Exercise> workout_exerciceList = workoutExerciseDao.findWorkout_ExercisesByWorkout(workout);
        return workout_exerciceList;
    }

    public void addExercise(Long workoutId, Long exerciseId, int series, int repetitions) {
        String author = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findByUsername(author);
        Workout workout = workoutDao.getWorkoutById(workoutId);
        Exercise exercise = exerciseDao.getExerciseById(exerciseId);
        if (author.equals(workout.getUser().getUsername())){
            Workout_Exercise workoutExercise = new Workout_Exercise();
            workoutExercise.setWorkout(workout);
            workoutExercise.setExercise(exercise);
            workoutExercise.setSeries(series);
            workoutExercise.setRepetitions(repetitions);
            workoutExerciseDao.save(workoutExercise);
        }

    }
}
