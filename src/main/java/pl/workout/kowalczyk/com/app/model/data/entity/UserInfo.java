package pl.workout.kowalczyk.com.app.model.data.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by JK on 2016-09-17.
 */
@Entity
@Table(name = "saw_userInfo")
public class UserInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uinfo_id;

    @OneToOne()
    @JoinColumn(name = "user_id")
    private User user_id;

    @OneToOne
    @JoinColumn(name = "uweight_id")
    private UserWeight actual_weight;

    @OneToOne
    @JoinColumn(name = "exercise_id")
    private Exercise efavourite_id;


    public int getUinfo_id() {
        return uinfo_id;
    }

    public void setUinfo_id(int uinfo_id) {
        this.uinfo_id = uinfo_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public UserWeight getActual_weight() {
        return actual_weight;
    }

    public void setActual_weight(UserWeight actual_weight) {
        this.actual_weight = actual_weight;
    }

    public Exercise getEfavourite_id() {
        return efavourite_id;
    }

    public void setEfavourite_id(Exercise efavourite_id) {
        this.efavourite_id = efavourite_id;
    }
}
