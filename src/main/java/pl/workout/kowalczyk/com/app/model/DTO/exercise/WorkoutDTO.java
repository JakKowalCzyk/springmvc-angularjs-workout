package pl.workout.kowalczyk.com.app.model.DTO.exercise;

import pl.workout.kowalczyk.com.app.model.DTO.ObjectDTO;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-11-18.
 */
public class WorkoutDTO extends ObjectDTO {

    private Long user_id;

    private Date date;

    private List<Long> userExercises;

    public WorkoutDTO() {
    }


    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Long> getUserExercises() {
        return userExercises;
    }

    public void setUserExercises(List<Long> userExercises) {
        this.userExercises = userExercises;
    }
}
