package pl.workout.kowalczyk.com.app.model.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by JK on 2016-09-17.
 */
@Entity
@Table(name = "saw_userWeight")
public class UserWeight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int uweight_id;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private User user_id;

    private int weight_kg;

    private Date data;

    public int getUweight_id() {
        return uweight_id;
    }

    public void setUweight_id(int uweight_id) {
        this.uweight_id = uweight_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public int getWeight_kg() {
        return weight_kg;
    }

    public void setWeight_kg(int weight_kg) {
        this.weight_kg = weight_kg;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date date) {
        this.data = date;
    }
}