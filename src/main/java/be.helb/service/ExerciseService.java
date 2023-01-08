package be.helb.service;

import be.helb.DAO.ExerciseDao;
import be.helb.DAO.UserDao;
import be.helb.DAO.WorkoutDao;
import be.helb.model.Exercise;
import be.helb.model.User;
import be.helb.model.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ExerciseService {
    @Autowired
    private ExerciseDao exerciseDao;
    @Autowired
    private UserDao userDao;

    public ExerciseService(ExerciseDao exerciseDao) {
        this.exerciseDao = exerciseDao;
    }


    public List<Exercise> getAllExercises(){
        List<Exercise> exerciseList = exerciseDao.findAll();
        return exerciseList;
    }

    public Exercise createExercise(String name, String description) {
        Exercise exercise = new Exercise();
        exercise.setName(name);
        exercise.setDescription(description);
        exerciseDao.save(exercise);
        return exercise;
    }

    public void updateExercise(Long exerciseId, String name, String description) {
       Exercise exercise = exerciseDao.getExerciseById(exerciseId);
        if (exercise != null){
            exercise.setName(name);
            exercise.setDescription(description);
            exerciseDao.save(exercise);
        }
    }

    public void deleteExerciseById(Long exerciseId) {
        Exercise exercise = exerciseDao.getExerciseById(exerciseId);
        if (exercise != null){
            exerciseDao.deleteById(exerciseId);
        }
    }

    public Exercise saveExercice(Exercise exercise) {
       return exerciseDao.save(exercise);
    }

    public  List<Exercise> getSearchedExercises(String name) {
        List<Exercise> exerciseList = exerciseDao.findByName(name);
        return exerciseList;
    }
}
