package com.kowalczyk.workouter.model.BO.exercise;

import com.kowalczyk.workouter.model.BO.user.AbstractUserObject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by JK on 2016-09-17.
 */
@Entity
public class Workout extends AbstractUserObject {

    private Date date;

    private List<UserExercise> userExercises = new ArrayList<>();

    public Workout(Date date) {
        this.date = date;
    }

    public Workout() {
    }

    @PrePersist
    public void prePersist() {
        getUser().getWorkouts().add(this);
    }

    @PreRemove
    public void preRemove() {
        getUser().getWorkouts().remove(this);
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workoutId")
    public List<UserExercise> getUserExercises() {
        return userExercises;
    }

    public void setUserExercises(List<UserExercise> userExercises) {
        this.userExercises = userExercises;
    }
}
