package be.helb.service;

import be.helb.DAO.ExerciceDao;
import be.helb.model.Exercice;
import org.easymock.EasyMock;
import org.junit.jupiter.api.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MusculationServiceTestExo {
    private ExerciceDao exerciceDao;
    private MusculationService musculationService;

    @Test
    public void testGetAllExercices(){
        //Simulation de données afin d'effectuer des tests
        List<Exercice> exerciceList = List.of(new Exercice("abs"), new Exercice("pushUp"));
        exerciceDao = EasyMock.mock(ExerciceDao.class);
        EasyMock.expect(exerciceDao.findAll()).andReturn(exerciceList);
        musculationService = new MusculationService(exerciceDao);
        EasyMock.replay(exerciceDao);
        List<Exercice> result = musculationService.getAllExercice();
        EasyMock.verify(exerciceDao);
        assertEquals(2, result.size());

    }
}
