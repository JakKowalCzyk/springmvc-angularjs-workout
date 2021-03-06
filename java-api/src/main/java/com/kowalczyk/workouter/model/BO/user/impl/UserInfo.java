package com.kowalczyk.workouter.model.BO.user.impl;

import com.kowalczyk.workouter.model.BO.ModelObject;
import com.kowalczyk.workouter.model.BO.exercise.Exercise;
import com.kowalczyk.workouter.model.BO.user.User;
import com.kowalczyk.workouter.model.exception.CannotCreateObjectException;

import javax.persistence.*;

/**
 * Created by JK on 2016-09-17.
 */
@Entity
public class UserInfo extends ModelObject {

    private UserWeight actualWeight;

    private Exercise favouriteExercise;

    private User user;

    public UserInfo() {
    }

    @PrePersist
    public void prePersist() {
        if (getUser().getUserInfo() != null) {
            throw new CannotCreateObjectException(UserInfo.class.getName());
        }
        getUser().setUserInfo(this);
    }

    @PreRemove
    public void preRemove() {
        if (getUser() != null) {
            getUser().setUserInfo(null);
        }
        if (getActualWeight() != null) {
            this.setActualWeight(null);
        }
    }

    @OneToOne
    @JoinColumn(name = "weight_id")
    public UserWeight getActualWeight() {
        return actualWeight;
    }

    public void setActualWeight(UserWeight actualWeight) {
        this.actualWeight = actualWeight;
    }

    @OneToOne
    @JoinColumn(name = "exercise_id")
    public Exercise getFavouriteExercise() {
        return favouriteExercise;
    }

    public void setFavouriteExercise(Exercise exerciseFavouriteId) {
        this.favouriteExercise = exerciseFavouriteId;
    }

    @OneToOne(cascade = {CascadeType.MERGE})
    public User getUser() {
        return user;
    }

    public void setUser(User userId) {
        this.user = userId;
    }

}
