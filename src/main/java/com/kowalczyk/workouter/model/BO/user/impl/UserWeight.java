package com.kowalczyk.workouter.model.BO.user.impl;

import com.kowalczyk.workouter.model.BO.user.AbstractUserObject;

import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
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

    @PrePersist
    public void prePersist() {
        getUser().getUserWeightList().add(this);
    }

    @PreRemove
    public void preRemove() {
        getUser().getUserWeightList().remove(this);
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
