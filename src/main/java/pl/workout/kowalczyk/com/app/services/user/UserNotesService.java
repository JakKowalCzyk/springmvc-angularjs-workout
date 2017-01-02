package pl.workout.kowalczyk.com.app.services.user;

import pl.workout.kowalczyk.com.app.model.BO.user.UserNotes;
import pl.workout.kowalczyk.com.app.model.DTO.user.UserNotesDTO;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
public interface UserNotesService {

    UserNotes mapUserNotesDtoToBo(UserNotesDTO userNotesDTO);

    UserNotesDTO mapUserNotesBoToDto(UserNotes userNotes);

    void saveUserNotes(UserNotesDTO userNotesDTO);

    void updateUserNotes(UserNotesDTO userNotesDTO);

    void deleteUserNotes(Integer noteId);

    List<UserNotesDTO> getUserNotesByUserId(int userId);

    List<UserNotesDTO> getNotesByDate(int userId, Date date);
}
