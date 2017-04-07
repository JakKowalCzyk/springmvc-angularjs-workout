package pl.workout.kowalczyk.com.app.model.BO.user.impl;

import pl.workout.kowalczyk.com.app.model.BO.user.AbstractUserObject;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by JK on 2016-09-17.
 */
@Entity
public class UserWeight extends AbstractUserObject {

    private int weightKg;

    private Date date;

    public UserWeight() {
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

}
