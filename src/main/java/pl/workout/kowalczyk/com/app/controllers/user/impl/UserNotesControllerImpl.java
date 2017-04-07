package pl.workout.kowalczyk.com.app.controllers.user.impl;

/**
 * Created by JK on 2017-01-22.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.workout.kowalczyk.com.app.controllers.impl.ModelControllerImpl;
import pl.workout.kowalczyk.com.app.controllers.user.UserNotesController;
import pl.workout.kowalczyk.com.app.mapper.user.impl.UserNotesMapper;
import pl.workout.kowalczyk.com.app.model.BO.user.impl.UserNotes;
import pl.workout.kowalczyk.com.app.model.DTO.user.impl.UserNotesDTO;
import pl.workout.kowalczyk.com.app.services.user.UserNotesService;

import java.sql.Date;
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
    public List<UserNotesDTO> getUserNotesById(@PathVariable Long id) {
        return ((UserNotesService) getModelService()).getUserNotesByUserId(id).stream().map(userNotes -> getModelMapper().mapToDTO(userNotes)).collect(Collectors.toList());
    }

    @Override
    public List<UserNotesDTO> getUserNotesByDate(@PathVariable Long id, @PathVariable Date date) {
        return ((UserNotesService) getModelService()).getNotesByDate(id, date).stream().map(userNotes -> getModelMapper().mapToDTO(userNotes)).collect(Collectors.toList());
    }
}
