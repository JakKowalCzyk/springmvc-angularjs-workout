package com.kowalczyk.workouter.model.DTO.user.impl;

import com.kowalczyk.workouter.model.DTO.user.AbstractUserObjectDTO;

import java.util.Date;

/**
 * Created by JK on 2016-11-18.
 */
public class UserWeightDTO extends AbstractUserObjectDTO {

    private Integer weightKg;

    private Date date;

    public UserWeightDTO() {
    }

    public Integer getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(Integer weightKg) {
        this.weightKg = weightKg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
