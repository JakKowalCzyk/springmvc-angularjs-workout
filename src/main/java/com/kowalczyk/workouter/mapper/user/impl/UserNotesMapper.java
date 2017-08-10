package com.kowalczyk.workouter.mapper.user.impl;

import com.kowalczyk.workouter.mapper.user.AbstractUserMapper;
import com.kowalczyk.workouter.model.BO.user.impl.UserNote;
import com.kowalczyk.workouter.model.DTO.user.impl.UserNoteDTO;
import org.springframework.stereotype.Component;

/**
 * Created by JK on 2017-02-18.
 */
@Component
public class UserNotesMapper extends AbstractUserMapper<UserNote, UserNoteDTO> {

    @Override
    protected UserNote buildUserObject(UserNoteDTO objectDTO) {
        UserNote userNote = new UserNote();
        userNote.setDate(objectDTO.getDate());
        userNote.setNote(objectDTO.getNote());
        return userNote;
    }

    @Override
    protected UserNoteDTO buildUserDTOObject(UserNote modelObject) {
        UserNoteDTO userNoteDTO = new UserNoteDTO();
        userNoteDTO.setDate(modelObject.getDate());
        userNoteDTO.setNote(modelObject.getNote());
        return userNoteDTO;
    }
}
