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
public class Workout extends AbstractModel {

    private Integer id;

    private UserDetails userId;

    private Date date;

    private List<UserExercise> userExercises;

    public Workout(UserDetails userId, Date date) {
        this.userId = userId;
        this.date = date;
    }

    public Workout() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workout_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "user_details_id")
    public UserDetails getUserId() {
        return userId;
    }

    public void setUserId(UserDetails userId) {
        this.userId = userId;
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
