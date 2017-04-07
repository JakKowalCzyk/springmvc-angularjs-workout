package pl.workout.kowalczyk.com.app.services.user;

import pl.workout.kowalczyk.com.app.model.BO.user.impl.UserNotes;
import pl.workout.kowalczyk.com.app.services.ModelService;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
public interface UserNotesService extends ModelService<UserNotes> {

    List<UserNotes> getUserNotesByUserId(Long userId);

    List<UserNotes> getNotesByDate(Long userId, Date date);
}
