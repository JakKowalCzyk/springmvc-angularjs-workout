package pl.workout.kowalczyk.com.app.model.BO.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.workout.kowalczyk.com.app.model.BO.security.UserDetails;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by JK on 2016-09-17.
 */
@Entity
@Table(name = "saw_userWeight")
public class UserWeight  {

    @Column(name = "weight_id")
    private int weight_id;

    private UserDetails user_id;

    private int weight_kg;

    private Date date;

    public UserWeight(UserDetails user_id, int weight_kg, Date date) {
        this.user_id = user_id;
        this.weight_kg = weight_kg;
        this.date = date;
    }

    private UserInfo userInfo_id;

    public UserWeight() {
    }

    public void setUser_id(UserDetails user_id) {
        this.user_id = user_id;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getWeight_id() {
        return weight_id;
    }

    public void setWeight_id(int weight_id) {
        this.weight_id = weight_id;
    }

    public int getWeight_kg() {
        return weight_kg;
    }

    public void setWeight_kg(int weight_kg) {
        this.weight_kg = weight_kg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @OneToOne(mappedBy = "actual_weight")
    public UserInfo getUserInfo_id() {
        return userInfo_id;
    }

    public void setUserInfo_id(UserInfo userInfo_id) {
        this.userInfo_id = userInfo_id;
    }

    @ManyToOne
    public UserDetails getUser_id() {
        return user_id;
    }


}
