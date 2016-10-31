package pl.workout.kowalczyk.com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.workout.kowalczyk.com.app.model.data.entity.UserNotes;
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
    public ResponseEntity saveUserNote(@RequestBody UserNotes userNotes) {
        userNotesService.saveUserNotes(userNotes);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateUserNote(@RequestBody UserNotes userNotes) {
        userNotesService.updateUserNotes(userNotes);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteUserNote(@RequestBody UserNotes userNotes) {
        userNotesService.deleteUserNotes(userNotes);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public List<UserNotes> getUserNotesById(@PathVariable int userId) {
        return userNotesService.getUserNotesByUserId(userId);
    }

    @RequestMapping(value = "/{userId}/{date", method = RequestMethod.GET)
    public UserNotes getUserNotesByDate(@PathVariable int userId, @PathVariable Date date) {
        return userNotesService.getSingleNoteByDate(userId, date);
    }
}
