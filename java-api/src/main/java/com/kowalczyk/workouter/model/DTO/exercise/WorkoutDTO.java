package com.kowalczyk.workouter.model.DTO.exercise;

import com.kowalczyk.workouter.model.DTO.ObjectDTO;

import java.util.Date;
import java.util.List;

/**
 * Created by JK on 2016-11-18.
 */
public class WorkoutDTO extends ObjectDTO {

    private Long userId;

    private Date date;

    private List<Long> userExercises;

    public WorkoutDTO() {
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long user_id) {
        this.userId = user_id;
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
