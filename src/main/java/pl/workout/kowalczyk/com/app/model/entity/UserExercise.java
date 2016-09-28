package pl.workout.kowalczyk.com.app.model.entity;

import javax.persistence.*;

/**
 * Created by JK on 2016-09-17.
 */
@Entity
@Table(name = "saw_userExercise")
public class UserExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int usexercise_id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Exercise exercise;

//    @OneToOne(cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    private User user_id;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout_id;

    private int repeat;

    private int series;

//    private Date date;

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Workout getWorkout_id() {
        return workout_id;
    }

    public void setWorkout_id(Workout workout) {
        this.workout_id = workout;
    }

    public int getUsexercise_id() {
        return usexercise_id;
    }

    public void setUsexercise_id(int usexercise_id) {
        this.usexercise_id = usexercise_id;
    }

//    public User getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(User user_id) {
//        this.user_id = user_id;
//    }
//
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

//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
}
