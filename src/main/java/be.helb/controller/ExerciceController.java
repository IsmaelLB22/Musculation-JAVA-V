package be.helb.controller;

import be.helb.DAO.ExerciceDao;
import be.helb.DAO.UserDao;
import be.helb.model.Exercice;
import be.helb.model.User;
import be.helb.service.MusculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExerciceController {
    private MusculationService musculationService;
    @Autowired
    private ExerciceDao exerciceDao;

    public ExerciceController(ExerciceDao exerciceDao){
        this.exerciceDao = exerciceDao;
    }

    @GetMapping("/HelloWorld")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/Exercices")
    public List<Exercice> getAllExercices(){
        return exerciceDao.findAll();
    }
    @PostMapping("/new exercices")
    public void newExercice(@RequestBody Exercice exercice){
        exerciceDao.save(exercice);
    }
}
