package pl.workout.kowalczyk.com.app.model.BO.exercise;

import pl.workout.kowalczyk.com.app.model.BO.AbstractModel;

import javax.persistence.*;

/**
 * Created by JK on 2016-09-17.
 */
@Entity
public class UserExercise  extends AbstractModel{
    private Integer id;

    private Exercise exercise;

    private Workout workoutId;

    private int repeat;

    private int series;

    public UserExercise() {
    }

    public UserExercise(int repeat, int series) {
        this.repeat = repeat;
        this.series = series;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_exercise_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    public Workout getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Workout workout) {
        this.workoutId = workout;
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
