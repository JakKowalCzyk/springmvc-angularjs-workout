package pl.workout.kowalczyk.com.app.model.BO.user;

import pl.workout.kowalczyk.com.app.model.BO.ModelObject;
import pl.workout.kowalczyk.com.app.model.BO.security.UserDetails;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * Created by JK on 2016-09-17.
 */
@Entity
public class UserNotes extends ModelObject {

    private UserDetails user_id;

    private String note;

    private Date date;

    public UserNotes() {
    }

    @OneToOne
    @JoinColumn(name = "user_details_id")
    public UserDetails getUser_id() {
        return user_id;
    }

    public void setUser_id(UserDetails user_id) {
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
