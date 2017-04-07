package pl.workout.kowalczyk.com.app.model.BO.user.impl;

import pl.workout.kowalczyk.com.app.model.BO.exercise.Exercise;
import pl.workout.kowalczyk.com.app.model.BO.user.AbstractUserObject;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Created by JK on 2016-09-17.
 */
@Entity
public class UserInfo extends AbstractUserObject {

    private UserWeight actualWeight;

    private Exercise exerciseFavouriteId;

    public UserInfo() {
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
    public Exercise getExerciseFavouriteId() {
        return exerciseFavouriteId;
    }

    public void setExerciseFavouriteId(Exercise exerciseFavouriteId) {
        this.exerciseFavouriteId = exerciseFavouriteId;
    }
}
