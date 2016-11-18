package pl.workout.kowalczyk.com.app.model.BO;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by JK on 2016-09-17.
 */
@Entity
@Table(name = "saw_userInfo")
public class UserInfo extends BaseModel implements Serializable {

    private int userInfo_id;

    private User user_id;

    private UserWeight actual_weight;

    private Exercise exerciseFavourite_id;

    public void setUserInfo_id(int uinfo_id) {
        this.userInfo_id = uinfo_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getUserInfo_id() {
        return userInfo_id;
    }

    @OneToOne
    @JoinColumn(name = "user_id")
    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
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
