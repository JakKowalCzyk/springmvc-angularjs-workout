package pl.workout.kowalczyk.com.app.model.BO.user;

import pl.workout.kowalczyk.com.app.model.BO.AbstractModel;
import pl.workout.kowalczyk.com.app.model.BO.exercise.Exercise;
import pl.workout.kowalczyk.com.app.model.BO.security.UserDetails;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by JK on 2016-09-17.
 */
@Entity
@Table(name = "saw_userInfo")
public class UserInfo extends AbstractModel  {
    private Integer id;
    private UserDetails user_id;

    private UserWeight actual_weight;

    private Exercise exerciseFavourite_id;

    public UserInfo(int userInfo_id) {
        this.id = userInfo_id;
    }

    public UserInfo() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_info_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @OneToOne
    @JoinColumn(name = "user_details_id")
    public UserDetails getUser_id() {
        return user_id;
    }

    public void setUser_id(UserDetails user_id) {
        this.user_id = user_id;
    }

    @OneToOne
    @JoinColumn(name = "weight_id")
    public UserWeight getActual_weight() {
        return actual_weight;
    }

    public void setActual_weight(UserWeight actual_weight) {
        this.actual_weight = actual_weight;
    }

    @OneToOne
    @JoinColumn(name = "exercise_id")
    public Exercise getExerciseFavourite_id() {
        return exerciseFavourite_id;
    }

    public void setExerciseFavourite_id(Exercise exerciseFavourite_id) {
        this.exerciseFavourite_id = exerciseFavourite_id;
    }
}
