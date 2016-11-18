package pl.workout.kowalczyk.com.app.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.workout.kowalczyk.com.app.model.BO.User;
import pl.workout.kowalczyk.com.app.model.BO.UserExercise;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JK on 2016-11-18.
 */
public class WorkoutDTO {
    private Integer workout_id ;

    private Integer user_id;

    private Date date;

    private List<UserExercise> userExercises;

    public WorkoutDTO(Integer workout_id, Integer user_id, Date date, List<UserExercise> userExercises) {
        this.workout_id = workout_id;
        this.user_id = user_id;
        this.date = date;
        this.userExercises = userExercises;
    }

    public Integer getWorkout_id() {
        return workout_id;
    }

    public void setWorkout_id(Integer workout_id) {
        this.workout_id = workout_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<UserExercise> getUserExercises() {
        return userExercises;
    }

    public void setUserExercises(List<UserExercise> userExercises) {
        this.userExercises = userExercises;
    }
}
