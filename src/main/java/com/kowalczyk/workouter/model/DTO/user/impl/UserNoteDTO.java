package com.kowalczyk.workouter.model.DTO.user.impl;

import com.kowalczyk.workouter.model.DTO.user.AbstractUserObjectDTO;

import java.util.Date;

/**
 * Created by JK on 2016-11-18.
 */
public class UserNoteDTO extends AbstractUserObjectDTO {
    private String note;
    private Date date;

    public UserNoteDTO() {
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
