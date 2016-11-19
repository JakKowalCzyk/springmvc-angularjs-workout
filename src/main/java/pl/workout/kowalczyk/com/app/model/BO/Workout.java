package pl.workout.kowalczyk.com.app.model.BO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.workout.kowalczyk.com.app.model.DTO.UserExerciseDTO;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JK on 2016-09-17.
 */
@Entity()
@Table(name = "saw_workout")
public class Workout  extends BaseModel {

    private int workout_id ;

    @JsonIgnore
    private User user_id;

    private Date date;

    private List<UserExercise> userExercises;

    public Workout(int workout_id, User user_id, Date date, List<UserExercise> userExercises) {
        this.workout_id = workout_id;
        this.user_id = user_id;
        this.date = date;
        this.userExercises = userExercises;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getWorkout_id() {
        return workout_id;
    }

    public void setWorkout_id(int workout_id) {
        this.workout_id = workout_id;
    }

    @OneToOne
    @JoinColumn(name = "user_id")
    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
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
