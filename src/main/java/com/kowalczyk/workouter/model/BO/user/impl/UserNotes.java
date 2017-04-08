package com.kowalczyk.workouter.model.BO.user.impl;

import com.kowalczyk.workouter.model.BO.user.AbstractUserObject;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by JK on 2016-09-17.
 */
@Entity
public class UserNotes extends AbstractUserObject {

    private String note;

    private Date date;

    public UserNotes() {
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
