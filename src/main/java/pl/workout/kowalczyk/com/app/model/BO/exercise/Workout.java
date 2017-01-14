package pl.workout.kowalczyk.com.app.model.BO.exercise;

import pl.workout.kowalczyk.com.app.model.BO.AbstractModel;
import pl.workout.kowalczyk.com.app.model.BO.security.UserDetails;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-09-17.
 */
@Entity()
@Table(name = "saw_workout")
public class Workout extends AbstractModel {

    private UserDetails user_id;

    private Date date;

    private List<UserExercise> userExercises;

    public Workout(UserDetails user_id, Date date) {
        this.user_id = user_id;
        this.date = date;
    }

    public Workout() {
    }

    @OneToOne
    @JoinColumn(name = "user_id")
    public UserDetails getUser_id() {
        return user_id;
    }

    public void setUser_id(UserDetails user_id) {
        this.user_id = user_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workout_id")
    public List<UserExercise> getUserExercises() {
        return userExercises;
    }

    public void setUserExercises(List<UserExercise> userExercises) {
        this.userExercises = userExercises;
    }
}
