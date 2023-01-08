package be.helb.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity

public class Workout_Exercise implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_workout")
    private Workout workout;

    @ManyToOne
    @JoinColumn(name = "id_exercise")
    private Exercise exercise;

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    @Column(name = "series")
    private int series;
    @Column(name = "repetitions")
    private int repetitions;

    public Workout_Exercise() {
    }



    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }


}
