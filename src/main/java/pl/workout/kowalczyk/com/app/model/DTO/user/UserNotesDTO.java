package pl.workout.kowalczyk.com.app.model.DTO.user;

import pl.workout.kowalczyk.com.app.model.DTO.BaseModel;

import java.sql.Date;

/**
 * Created by JK on 2016-11-18.
 */
public class UserNotesDTO extends BaseModel {
    private Integer user_id;
    private String note;
    private Date date;

    public UserNotesDTO() {
    }


    public UserNotesDTO(Integer userNotesId, Integer user_id, String note, Date date) {
        super(userNotesId);
        this.user_id = user_id;
        this.note = note;
        this.date = date;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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
