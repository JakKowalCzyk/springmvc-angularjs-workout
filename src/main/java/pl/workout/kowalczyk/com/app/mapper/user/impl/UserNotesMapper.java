package pl.workout.kowalczyk.com.app.mapper.user.impl;

import org.springframework.stereotype.Component;
import pl.workout.kowalczyk.com.app.mapper.user.AbstractUserMapper;
import pl.workout.kowalczyk.com.app.model.BO.user.impl.UserNotes;
import pl.workout.kowalczyk.com.app.model.DTO.user.impl.UserNotesDTO;

/**
 * Created by JK on 2017-02-18.
 */
@Component
public class UserNotesMapper extends AbstractUserMapper<UserNotes, UserNotesDTO> {

    @Override
    protected UserNotes buildUserObject(UserNotesDTO objectDTO) {
        UserNotes userNotes = new UserNotes();
        userNotes.setDate(objectDTO.getDate());
        userNotes.setNote(objectDTO.getNote());
        return userNotes;
    }

    @Override
    protected UserNotesDTO buildUserDTOObject(UserNotes modelObject) {
        UserNotesDTO userNotesDTO = new UserNotesDTO();
        userNotesDTO.setDate(modelObject.getDate());
        userNotesDTO.setNote(modelObject.getNote());
        return userNotesDTO;
    }
}
