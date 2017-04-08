package com.kowalczyk.workouter.mapper.user.impl;

import com.kowalczyk.workouter.mapper.user.AbstractUserMapper;
import com.kowalczyk.workouter.model.BO.user.impl.UserNotes;
import com.kowalczyk.workouter.model.DTO.user.impl.UserNotesDTO;
import org.springframework.stereotype.Component;

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
