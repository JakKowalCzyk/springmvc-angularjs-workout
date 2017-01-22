package pl.workout.kowalczyk.com.app.controllers.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.workout.kowalczyk.com.app.model.DTO.user.UserNotesDTO;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2017-01-22.
 */
@Api(tags = {"User Notes API"}, description = "Services for user's notes")
@RequestMapping("/user/notes")
public interface UserNotesController {

    @ApiOperation(value = "Save new User's note")
    @RequestMapping(method = RequestMethod.POST)
    void saveUserNote(@RequestBody UserNotesDTO userNotes);

    @ApiOperation(value = "Update existing User's note")
    @RequestMapping(method = RequestMethod.PUT)
    void updateUserNote(@RequestBody UserNotesDTO userNotes);

    @ApiOperation(value = "Delete User's note")
    @RequestMapping(value = "/note/{noteId}", method = RequestMethod.DELETE)
    void deleteUserNote(@PathVariable Integer noteId);

    @ApiOperation(value = "Get all notes for user")
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    List<UserNotesDTO> getUserNotesById(@PathVariable int userId);

    @ApiOperation(value = "Get all notes for user by date")
    @RequestMapping(value = "/user/{userId}/date/{date}", method = RequestMethod.GET)
    List<UserNotesDTO> getUserNotesByDate(@PathVariable int userId, @PathVariable Date date);
}
