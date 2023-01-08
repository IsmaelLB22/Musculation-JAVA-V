package be.helb.service;

import be.helb.DAO.ExerciseDao;
import be.helb.DAO.UserDao;
import be.helb.DAO.WorkoutDao;
import be.helb.DAO.Workout_ExerciseDao;
import be.helb.model.Exercise;
import be.helb.model.User;
import be.helb.model.Workout;
import org.easymock.EasyMock;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@RestController
@RequestMapping("/api/Tests")
public class WorkoutServiceTestExo {
    @Autowired
    private ExerciseDao exerciseDao;
    @Autowired
    private ExerciseService exerciseService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;
    @Autowired
    private WorkoutDao workoutDao;
    @Autowired
    private WorkoutService workoutService;
    @Autowired
    private Workout_ExerciseDao workout_exerciseDao;
    @Autowired
    private Workout_ExerciseService workout_exerciseService;

    @Test
    public void testGetAllExercises(){
        //Simulation de données afin d'effectuer des tests
        List<Exercise> exerciseList = List.of(new Exercise("abs"), new Exercise("pushUp"));
        exerciseDao = EasyMock.mock(ExerciseDao.class);
        EasyMock.expect(exerciseDao.findAll()).andReturn(exerciseList);
        exerciseService = new ExerciseService(exerciseDao);
        EasyMock.replay(exerciseDao);
        List<Exercise> result = exerciseService.getAllExercises();
        EasyMock.verify(exerciseDao);
        assertEquals(2, result.size());

    }

    @Test
    public void testGetAllWorkouts(){
        //Simulation de données afin d'effectuer des tests
        List<Workout> workoutList = List.of(new Workout("spartan"), new Workout("persian"));
        workoutDao = EasyMock.mock(WorkoutDao.class);
        EasyMock.expect(workoutDao.findAll()).andReturn(workoutList);
        workoutService = new WorkoutService(workoutDao);
        EasyMock.replay(workoutDao);
        List<Workout> result = workoutService.getAllWorkout();
        EasyMock.verify(workoutDao);
        assertEquals(2, result.size());

    }

    @Test
    public void testGetAllUser(){
        //Simulation de données afin d'effectuer des tests
        List<User> userList = List.of(new User("John"), new User("Doe"));
        userDao = EasyMock.mock(UserDao.class);
        EasyMock.expect(userDao.findAll()).andReturn(userList);
        userService = new UserService(userDao);
        EasyMock.replay(userDao);
        List<User> result = userService.getAllUser();
        EasyMock.verify(userDao);
        assertEquals(2, result.size());
    }

    @Test
    public void testAddExercise() {
        ExerciseDao exerciseDao = EasyMock.mock(ExerciseDao.class);
        Exercise exercise = new Exercise("Traction");
        EasyMock.expect(exerciseDao.save(exercise)).andReturn(exercise);
        EasyMock.replay(exerciseDao);
        ExerciseService exerciseService = new ExerciseService(exerciseDao);
        Exercise result = exerciseService.saveExercice(exercise);
        EasyMock.verify(exerciseDao);
        assertEquals(exercise, result);
        EasyMock.verify(exerciseDao);
    }


    @Test
    public void testAddWorkout() {
        WorkoutDao workoutDao = EasyMock.mock(WorkoutDao.class);
        Workout workout = new Workout("Entraînement de musculation");
        EasyMock.expect(workoutDao.save(workout)).andReturn(workout);
        WorkoutService workoutService = new WorkoutService(workoutDao);
        EasyMock.replay(workoutDao);
        workoutService.saveWorkout(workout);
        EasyMock.verify(workoutDao);
    }
}
