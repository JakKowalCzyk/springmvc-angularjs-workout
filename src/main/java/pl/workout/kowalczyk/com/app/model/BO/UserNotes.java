package pl.workout.kowalczyk.com.app.model.BO;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by JK on 2016-09-17.
 */
@Entity
@Table(name = "saw_userNotes")
public class UserNotes extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userNotes_id;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private User user_id;

    private String note;

    private Date date;

    public UserNotes(Integer userNotesId, User user_id, String note, Date date) {
        this.userNotes_id = userNotesId;
        this.user_id = user_id;
        this.note = note;
        this.date = date;
    }

    public UserNotes() {
    }

    public int getUserNotes_id() {
        return userNotes_id;
    }

    public void setUserNotes_id(int uweight_id) {
        this.userNotes_id = uweight_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
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
