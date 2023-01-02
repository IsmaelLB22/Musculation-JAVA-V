package be.helb.service;

import be.helb.DAO.ExerciceDao;
import be.helb.model.Exercice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusculationService {

    ExerciceDao exerciceDao;
    public MusculationService(ExerciceDao exerciceDao) {
        this.exerciceDao = exerciceDao;
    }

    public List<Exercice> getAllExercice(){
        List<Exercice> exerciceList = exerciceDao.findAll();
        return exerciceList;
    }
}
