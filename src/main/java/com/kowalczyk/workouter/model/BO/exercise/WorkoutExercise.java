package com.kowalczyk.workouter.model.BO.exercise;

import com.kowalczyk.workouter.model.BO.ModelObject;

import javax.persistence.*;

/**
 * Created by JK on 2016-09-17.
 */
@Entity
public class WorkoutExercise extends ModelObject {

    private Exercise exercise;

    private Workout workout;

    private int repeat;

    private int series;

    public WorkoutExercise() {
    }

    public WorkoutExercise(int repeat, int series) {
        this.repeat = repeat;
        this.series = series;
    }

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "exercise_id")
    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workoutId")
    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public int getRepeat() {
        return repeat;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

}
