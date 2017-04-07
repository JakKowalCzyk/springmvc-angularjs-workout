package pl.workout.kowalczyk.com.app.controllers.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.workout.kowalczyk.com.app.controllers.ModelController;
import pl.workout.kowalczyk.com.app.model.DTO.user.impl.UserNotesDTO;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2017-01-22.
 */
@Api(tags = {"User Notes API"}, description = "Services for user's notes")
@RequestMapping("/user/notes")
public interface UserNotesController extends ModelController<UserNotesDTO> {


    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    UserNotesDTO getObject(@PathVariable Long id);

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    UserNotesDTO updateObject(@RequestBody UserNotesDTO model);

    @Override
    @RequestMapping(method = RequestMethod.POST)
    UserNotesDTO addObject(@RequestBody UserNotesDTO model);

    @Override
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<UserNotesDTO> findAll();

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void deleteObject(@PathVariable Long id);

    @ApiOperation(value = "Get all notes for user")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    List<UserNotesDTO> getUserNotesById(@PathVariable Long id);

    @ApiOperation(value = "Get all notes for user by date")
    @RequestMapping(value = "/user/{id}/date/{date}", method = RequestMethod.GET)
    List<UserNotesDTO> getUserNotesByDate(@PathVariable Long id, @PathVariable Date date);
}
