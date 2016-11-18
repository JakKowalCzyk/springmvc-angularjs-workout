package pl.workout.kowalczyk.com.app.services.service;

import pl.workout.kowalczyk.com.app.model.BO.UserNotes;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
public interface UserNotesService {
    void saveUserNotes(UserNotes userNotes);

    void updateUserNotes(UserNotes userNotes);

    void deleteUserNotes(UserNotes userNotes);

    List<UserNotes> getUserNotesByUserId(int userId);

    UserNotes getSingleNoteByDate(int userId, Date date);
}
