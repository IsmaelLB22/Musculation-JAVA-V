package be.helb.service;

import be.helb.DAO.UserDao;
import be.helb.DAO.WorkoutDao;
import be.helb.model.User;
import be.helb.model.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WorkoutService {
    @Autowired
    private WorkoutDao workoutDao;
    @Autowired
    private UserDao userDao;

    public WorkoutService(WorkoutDao workoutDao) {
        this.workoutDao = workoutDao;
    }

    public List<Workout> getAllWorkout(){
        List<Workout> workoutList = workoutDao.findAll();
        return workoutList;
    }


    public List<Workout> getWorkoutByAuthor(String user) {
        return workoutDao.findAllByAuthor(user);
    }

    public Workout createWorkout(String name) {
        String author = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Date date = new Date();
        User user = userDao.findByUsername(author);
        Workout workout = new Workout();
        workout.setName(name);
        workout.setDate_posted(date);
        workout.setUser(user);
        workout.setAuthor(user.getUsername());
        workoutDao.save(workout);
        return workout;
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

    public void saveWorkout(Workout workout) {
        workoutDao.save(workout);
    }
}
