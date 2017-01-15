package pl.workout.kowalczyk.com.app.model.BO.user;

import pl.workout.kowalczyk.com.app.model.BO.AbstractModel;
import pl.workout.kowalczyk.com.app.model.BO.exercise.Exercise;
import pl.workout.kowalczyk.com.app.model.BO.security.UserDetails;

import javax.persistence.*;

/**
 * Created by JK on 2016-09-17.
 */
@Entity
public class UserInfo extends AbstractModel  {
    private Integer id;
    private UserDetails userId;

    private UserWeight actualWeight;

    private Exercise exerciseFavouriteId;

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
    public UserDetails getUserId() {
        return userId;
    }

    public void setUserId(UserDetails userId) {
        this.userId = userId;
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
