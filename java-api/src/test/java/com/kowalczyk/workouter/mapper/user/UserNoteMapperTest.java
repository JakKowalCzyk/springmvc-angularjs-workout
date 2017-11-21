package com.kowalczyk.workouter.mapper.user;

import com.kowalczyk.workouter.mapper.AbstractMapperTest;
import com.kowalczyk.workouter.mapper.user.impl.UserNotesMapper;
import com.kowalczyk.workouter.model.BO.user.impl.UserNote;
import com.kowalczyk.workouter.model.DTO.user.impl.UserNoteDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

/**
 * Created by JK on 2017-03-22.
 */
public class UserNoteMapperTest extends AbstractMapperTest {

    @Autowired
    private UserNotesMapper userNotesMapper;

    @Test
    public void mapToBO() throws Exception {
        UserNoteDTO userNoteDTO = new UserNoteDTO();
        userNoteDTO.setUserId(1L);
        userNoteDTO.setId(2L);
        userNoteDTO.setDate(new GregorianCalendar(2014, 02, 12).getTime());
        userNoteDTO.setNote("Note");
        UserNote userNote = userNotesMapper.mapToBO(userNoteDTO);
        assertEquals(userNoteDTO.getId(), userNote.getId());
        assertEquals(userNoteDTO.getUserId(), userNote.getUser().getId());
        assertEquals(userNoteDTO.getDate(), userNote.getDate());
        assertEquals(userNoteDTO.getNote(), userNote.getNote());
    }

    @Test
    public void mapToDTO() throws Exception {
        UserNote userNote = new UserNote();
        userNote.setUser(getUserDetailsTest());
        userNote.setId(2L);
        userNote.setDate(new GregorianCalendar(2014, 02, 12).getTime());
        userNote.setNote("Note");
        UserNoteDTO userNoteDTO = userNotesMapper.mapToDTO(userNote);
        assertEquals(userNote.getId(), userNoteDTO.getId());
        assertEquals(userNote.getUser().getId(), userNoteDTO.getUserId());
        assertEquals(userNote.getNote(), userNoteDTO.getNote());
        assertEquals(userNote.getDate(), userNoteDTO.getDate());
    }

}

