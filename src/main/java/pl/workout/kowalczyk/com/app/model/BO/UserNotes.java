package pl.workout.kowalczyk.com.app.model.BO;

import pl.workout.kowalczyk.com.app.model.DTO.BaseModel;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by JK on 2016-09-17.
 */
@Entity
@Table(name = "saw_userNotes")
public class UserNotes  {

    private int userNotes_id;

    private UserDetails user_id;

    private String note;

    private Date date;

    public UserNotes(UserDetails user_id, String note, Date date) {
        this.user_id = user_id;
        this.note = note;
        this.date = date;
    }

    public UserNotes() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getUserNotes_id() {
        return userNotes_id;
    }

    public void setUserNotes_id(int userNotes_id) {
        this.userNotes_id = userNotes_id;
    }

    @OneToOne
    @JoinColumn(name = "userId")
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
