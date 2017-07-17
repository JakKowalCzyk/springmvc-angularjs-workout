package com.kowalczyk.workouter.controllers.user.impl;

/**
 * Created by JK on 2017-01-22.
 */

import com.kowalczyk.workouter.controllers.impl.ModelControllerImpl;
import com.kowalczyk.workouter.controllers.user.UserNotesController;
import com.kowalczyk.workouter.mapper.user.impl.UserNotesMapper;
import com.kowalczyk.workouter.model.BO.user.impl.UserNotes;
import com.kowalczyk.workouter.model.DTO.user.impl.UserNotesDTO;
import com.kowalczyk.workouter.services.user.UserNotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserNotesControllerImpl extends ModelControllerImpl<UserNotes, UserNotesDTO> implements UserNotesController {

    @Autowired
    public UserNotesControllerImpl(UserNotesService modelService, UserNotesMapper modelMapper) {
        super(modelService, modelMapper);
    }

    @Override
    public UserNotesDTO getObject(@PathVariable Long id) {
        return super.getObject(id);
    }

    @Override
    public UserNotesDTO updateObject(@RequestBody UserNotesDTO model) {
        return super.updateObject(model);
    }

    @Override
    public UserNotesDTO addObject(@RequestBody UserNotesDTO model) {
        return super.addObject(model);
    }

    @Override
    public List<UserNotesDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteObject(@PathVariable Long id) {
        super.deleteObject(id);
    }

    @Override
    public boolean isExist(@PathVariable Long id) {
        return super.isExist(id);
    }

    @Override
    public List<UserNotesDTO> getUserNotesByUserId(@PathVariable Long id) {
        return ((UserNotesService) getModelService()).getUserNotesByUserId(id).stream().map(userNotes -> getModelMapper().mapToDTO(userNotes)).collect(Collectors.toList());
    }

    @Override
    public List<UserNotesDTO> getUserNotesByDate(@PathVariable Long id, @PathVariable Date date) {
        return ((UserNotesService) getModelService()).getNotesByDate(id, date).stream().map(userNotes -> getModelMapper().mapToDTO(userNotes)).collect(Collectors.toList());
    }
}
