package pl.workout.kowalczyk.com.app.model.BO.user;

import pl.workout.kowalczyk.com.app.model.BO.AbstractModel;
import pl.workout.kowalczyk.com.app.model.BO.security.UserDetails;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by JK on 2016-09-17.
 */
@Entity
public class UserWeight extends AbstractModel {
    private Integer id;

    private UserDetails userId;

    private int weightKg;

    private Date date;

    private UserInfo userInfoId;

    public UserWeight(UserDetails userId, int weightKg, Date date) {
        this.userId = userId;
        this.weightKg = weightKg;
        this.date = date;
    }

    public UserWeight() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_weight_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setUserId(UserDetails userId) {
        this.userId = userId;
    }

    public int getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(int weightKg) {
        this.weightKg = weightKg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @OneToOne(mappedBy = "actualWeight")
    public UserInfo getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(UserInfo userInfoId) {
        this.userInfoId = userInfoId;
    }

    @ManyToOne
    @JoinColumn(name = "user_details_id")
    public UserDetails getUserId() {
        return userId;
    }


}
