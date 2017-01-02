package pl.workout.kowalczyk.com.app.model.BO;

import pl.workout.kowalczyk.com.app.model.DTO.BaseModel;

import javax.persistence.*;

/**
 * Created by JK on 2016-09-17.
 */
@Entity
@Table(name = "saw_userExercise")
public class UserExercise  {

    private int userExercise_id;

    private Exercise exercise;

    private Workout workout_id;

    private int repeat;

    private int series;

    public UserExercise() {
    }

    public UserExercise(int repeat, int series) {
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "workout_id")
    public Workout getWorkout_id() {
        return workout_id;
    }

    public void setWorkout_id(Workout workout) {
        this.workout_id = workout;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getUserExercise_id() {
        return userExercise_id;
    }

    public void setUserExercise_id(int userExercise_id) {
        this.userExercise_id = userExercise_id;
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
