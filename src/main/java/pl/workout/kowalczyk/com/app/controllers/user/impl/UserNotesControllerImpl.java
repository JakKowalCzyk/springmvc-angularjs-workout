package pl.workout.kowalczyk.com.app.controllers.user.impl;

/**
 * Created by JK on 2017-01-22.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.workout.kowalczyk.com.app.controllers.user.UserNotesController;
import pl.workout.kowalczyk.com.app.model.DTO.user.UserNotesDTO;
import pl.workout.kowalczyk.com.app.services.user.UserNotesService;

import java.sql.Date;
import java.util.List;

@RestController
public class UserNotesControllerImpl implements UserNotesController {

    @Autowired
    private UserNotesService userNotesService;

    @Override
    public void saveUserNote(@RequestBody UserNotesDTO userNotes) {
        userNotesService.saveUserNotes(userNotes);
    }

    @Override
    public void updateUserNote(@RequestBody UserNotesDTO userNotes) {
        userNotesService.updateUserNotes(userNotes);
    }

    @Override
    public void deleteUserNote(@PathVariable Integer noteId) {
        userNotesService.deleteUserNotes(noteId);
    }

    @Override
    public List<UserNotesDTO> getUserNotesById(@PathVariable int userId) {
        return userNotesService.getUserNotesByUserId(userId);
    }

    @Override
    public List<UserNotesDTO> getUserNotesByDate(@PathVariable int userId, @PathVariable Date date) {
        return userNotesService.getNotesByDate(userId, date);
    }
}
