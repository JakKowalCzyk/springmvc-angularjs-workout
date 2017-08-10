package com.kowalczyk.workouter.controllers.user;

import com.kowalczyk.workouter.controllers.ModelController;
import com.kowalczyk.workouter.model.DTO.user.impl.UserNoteDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

/**
 * Created by JK on 2017-01-22.
 */
@Api(tags = {"User Notes API"}, description = "Services for user's notes")
@RequestMapping("/notes")
public interface UserNotesController extends ModelController<UserNoteDTO> {


    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    UserNoteDTO getObject(@PathVariable Long id);

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    UserNoteDTO updateObject(@RequestBody UserNoteDTO model);

    @Override
    @RequestMapping(method = RequestMethod.POST)
    UserNoteDTO addObject(@RequestBody UserNoteDTO model);

    @Override
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<UserNoteDTO> findAll();

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void deleteObject(@PathVariable Long id);

    @Override
    @RequestMapping(value = "/exist", method = RequestMethod.GET)
    boolean isExist(@PathVariable Long id);

    @ApiOperation(value = "Get all notes for user")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    List<UserNoteDTO> getUserNotesByUserId(@PathVariable Long id);

    @ApiOperation(value = "Get all notes for user by date")
    @RequestMapping(value = "/user/{id}/date/{date}", method = RequestMethod.GET)
    List<UserNoteDTO> getUserNotesByDate(@PathVariable Long id, @PathVariable Date date);
}
