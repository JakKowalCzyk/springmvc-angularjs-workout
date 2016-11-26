package pl.workout.kowalczyk.com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.workout.kowalczyk.com.app.model.DTO.UserNotesDTO;
import pl.workout.kowalczyk.com.app.services.service.UserNotesService;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-10-31.
 */
@RestController
@RequestMapping(value = "/user/notes")
public class UserNotesController {
    @Autowired
    private UserNotesService userNotesService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity saveUserNote(@RequestBody UserNotesDTO userNotes) {
        userNotesService.saveUserNotes(userNotes);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateUserNote(@RequestBody UserNotesDTO userNotes) {
        userNotesService.updateUserNotes(userNotes);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/note/{noteId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUserNote(@PathVariable Integer noteId) {
        userNotesService.deleteUserNotes(noteId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public List<UserNotesDTO> getUserNotesById(@PathVariable int userId) {
        return userNotesService.getUserNotesByUserId(userId);
    }

    @RequestMapping(value = "/{userId}/{date}", method = RequestMethod.GET)
    public List<UserNotesDTO> getUserNotesByDate(@PathVariable int userId, @PathVariable Date date) {
        return userNotesService.getNotesByDate(userId, date);
    }
}
