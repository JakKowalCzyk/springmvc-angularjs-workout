package pl.workout.kowalczyk.com.app.model.entity;

import javax.persistence.*;

/**
 * Created by JK on 2016-09-17.
 */
@Entity
@Table(name = "saw_favouriteExercise")
public class FavouriteExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int efavourite_id ;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Exercise exercise;

    @OneToOne
    @PrimaryKeyJoinColumn
    private UserInfo userInfo_id;

    public int getEfavourite_id() {
        return efavourite_id;
    }

    public void setEfavourite_id(int efavourite_id) {
        this.efavourite_id = efavourite_id;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public UserInfo getUserInfo_id() {
        return userInfo_id;
    }

    public void setUserInfo_id(UserInfo userInfo_id) {
        this.userInfo_id = userInfo_id;
    }
}
