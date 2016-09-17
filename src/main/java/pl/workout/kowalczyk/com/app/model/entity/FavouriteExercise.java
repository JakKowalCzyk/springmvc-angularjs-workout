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

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private User user_id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Exercise exercise;

    public int getEfavourite_id() {
        return efavourite_id;
    }

    public void setEfavourite_id(int efavourite_id) {
        this.efavourite_id = efavourite_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
