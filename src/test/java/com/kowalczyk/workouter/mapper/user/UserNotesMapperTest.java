package com.kowalczyk.workouter.mapper.user;

import com.kowalczyk.workouter.mapper.AbstractMapperTest;
import com.kowalczyk.workouter.mapper.user.impl.UserNotesMapper;
import com.kowalczyk.workouter.model.BO.user.impl.UserNotes;
import com.kowalczyk.workouter.model.DTO.user.impl.UserNotesDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

/**
 * Created by JK on 2017-03-22.
 */
public class UserNotesMapperTest extends AbstractMapperTest {

    @Autowired
    private UserNotesMapper userNotesMapper;

    @Test
    public void mapToBO() throws Exception {
        UserNotesDTO userNotesDTO = new UserNotesDTO();
        userNotesDTO.setUserId(1L);
        userNotesDTO.setId(2L);
        userNotesDTO.setDate(new GregorianCalendar(2014, 02, 12).getTime());
        userNotesDTO.setNote("Note");
        UserNotes userNotes = userNotesMapper.mapToBO(userNotesDTO);
        assertEquals(userNotesDTO.getId(), userNotes.getId());
        assertEquals(userNotesDTO.getUserId(), userNotes.getUser().getId());
        assertEquals(userNotesDTO.getDate(), userNotes.getDate());
        assertEquals(userNotesDTO.getNote(), userNotes.getNote());
    }

    @Test
    public void mapToDTO() throws Exception {
        UserNotes userNotes = new UserNotes();
        userNotes.setUser(getUserDetailsTest());
        userNotes.setId(2L);
        userNotes.setDate(new GregorianCalendar(2014, 02, 12).getTime());
        userNotes.setNote("Note");
        UserNotesDTO userNotesDTO = userNotesMapper.mapToDTO(userNotes);
        assertEquals(userNotes.getId(), userNotesDTO.getId());
        assertEquals(userNotes.getUser().getId(), userNotesDTO.getUserId());
        assertEquals(userNotes.getNote(), userNotesDTO.getNote());
        assertEquals(userNotes.getDate(), userNotesDTO.getDate());
    }

}

