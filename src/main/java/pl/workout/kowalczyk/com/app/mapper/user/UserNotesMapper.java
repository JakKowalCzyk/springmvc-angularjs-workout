package pl.workout.kowalczyk.com.app.mapper.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.workout.kowalczyk.com.app.mapper.impl.ModelMapperImpl;
import pl.workout.kowalczyk.com.app.model.BO.user.UserNotes;
import pl.workout.kowalczyk.com.app.model.DTO.user.UserNotesDTO;
import pl.workout.kowalczyk.com.app.services.user.UserDetailsService;

/**
 * Created by JK on 2017-02-18.
 */
@Component
public class UserNotesMapper extends ModelMapperImpl<UserNotes, UserNotesDTO> {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected UserNotes buildBO(UserNotesDTO objectDTO) {
        UserNotes userNotes = new UserNotes();
        userNotes.setDate(objectDTO.getDate());
        userNotes.setNote(objectDTO.getNote());
        userNotes.setUser_id(userDetailsService.getObject(objectDTO.getUser_id()));
        return userNotes;
    }

    @Override
    protected UserNotesDTO buildDTO(UserNotes modelObject) {
        UserNotesDTO userNotesDTO = new UserNotesDTO();
        userNotesDTO.setDate(modelObject.getDate());
        userNotesDTO.setNote(modelObject.getNote());
        userNotesDTO.setUser_id(modelObject.getUser_id().getId());
        return userNotesDTO;
    }
}
