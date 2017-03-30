package pl.workout.kowalczyk.com.app.mapper.user;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.workout.kowalczyk.com.app.mapper.AbstractMapperTest;
import pl.workout.kowalczyk.com.app.model.BO.user.UserNotes;
import pl.workout.kowalczyk.com.app.model.DTO.user.UserNotesDTO;

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
        userNotesDTO.setUser_id(1L);
        userNotesDTO.setId(2L);
        userNotesDTO.setDate(new GregorianCalendar(2014, 02, 12).getTime());
        userNotesDTO.setNote("Note");
        UserNotes userNotes = userNotesMapper.mapToBO(userNotesDTO);
        assertEquals(userNotesDTO.getId(), userNotes.getId());
        assertEquals(userNotesDTO.getUser_id(), userNotes.getUser_id().getId());
        assertEquals(userNotesDTO.getDate(), userNotes.getDate());
        assertEquals(userNotesDTO.getNote(), userNotes.getNote());
    }

    @Test
    public void mapToDTO() throws Exception {
        UserNotes userNotes = new UserNotes();
        userNotes.setUser_id(getUserDetailsTest());
        userNotes.setId(2L);
        userNotes.setDate(new GregorianCalendar(2014, 02, 12).getTime());
        userNotes.setNote("Note");
        UserNotesDTO userNotesDTO = userNotesMapper.mapToDTO(userNotes);
        assertEquals(userNotes.getId(), userNotesDTO.getId());
        assertEquals(userNotes.getUser_id().getId(), userNotesDTO.getUser_id());
        assertEquals(userNotes.getNote(), userNotesDTO.getNote());
        assertEquals(userNotes.getDate(), userNotesDTO.getDate());
    }

}

