package pl.workout.kowalczyk.com.app.dao.user;

import pl.workout.kowalczyk.com.app.dao.BaseDao;
import pl.workout.kowalczyk.com.app.model.BO.user.UserNotes;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-09-22.
 */
public interface UserNotesDao extends BaseDao<UserNotes> {
    List<UserNotes> getUserNotesByUserId(int userId);

    List<UserNotes> getSingleNoteByDate(int userId, Date date);
}
