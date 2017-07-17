package com.kowalczyk.workouter.controllers.user;

import com.kowalczyk.workouter.controllers.AbstractControllerTest;
import com.kowalczyk.workouter.model.DTO.user.impl.UserNotesDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by JK on 2017-07-12.
 */
public class UserNotesControllerTest extends AbstractControllerTest {

    @Autowired
    private UserNotesController userNotesController;

    @Test
    public void getObject() throws Exception {
        UserNotesDTO userNotesDTO = userNotesController.addObject(createUserNotesTest(new GregorianCalendar().getTime(), "note1"));
        UserNotesDTO expectedUserNotesDTO = userNotesController.getObject(userNotesDTO.getId());
        assertEquals(expectedUserNotesDTO.getDate(), userNotesDTO.getDate());
        assertEquals(expectedUserNotesDTO.getNote(), userNotesDTO.getNote());
        deleteNotes(userNotesDTO);
    }

    private void deleteNotes(UserNotesDTO userNotesDTO) {
        userNotesController.deleteObject(userNotesDTO.getId());
        assertFalse(userNotesController.isExist(userNotesDTO.getId()));
    }

    @Test
    public void updateObject() throws Exception {
        UserNotesDTO userNotesDTO = userNotesController.addObject(createUserNotesTest(new GregorianCalendar(2012, 8, 12).getTime(), "note1"));
        UserNotesDTO userNotesDTO1 = userNotesController.getObject(userNotesDTO.getId());
        userNotesDTO1.setDate(new GregorianCalendar(2021, 1, 11).getTime());
        userNotesDTO1.setNote("new note");
        userNotesDTO = userNotesController.updateObject(userNotesDTO1);
        assertEquals(userNotesDTO1.getId(), userNotesDTO.getId());
        assertEquals(userNotesDTO1.getDate(), userNotesDTO.getDate());
        assertEquals(userNotesDTO1.getNote(), userNotesDTO.getNote());
        deleteNotes(userNotesDTO);
        assertTrue(userNotesController.findAll().isEmpty());
    }

    @Test
    public void findAll() throws Exception {
        UserNotesDTO userNotesDTO1 = userNotesController.addObject(createUserNotesTest(new GregorianCalendar(2012, 8, 12).getTime(), "note1"));
        UserNotesDTO userNotesDTO2 = userNotesController.addObject(createUserNotesTest(new GregorianCalendar().getTime(), "note2"));
        UserNotesDTO userNotesDTO3 = userNotesController.addObject(createUserNotesTest(new GregorianCalendar(1990, 5, 11).getTime(), "note3"));
        List<UserNotesDTO> notesDTOList = userNotesController.findAll();
        assertEquals(3, notesDTOList.size());
        assertTrue(notesDTOList.stream().anyMatch(note -> note.getId().equals(userNotesDTO1.getId())));
        assertTrue(notesDTOList.stream().anyMatch(note -> note.getDate().equals(userNotesDTO1.getDate())));
        assertTrue(notesDTOList.stream().anyMatch(note -> note.getId().equals(userNotesDTO2.getId())));
        assertTrue(notesDTOList.stream().anyMatch(note -> note.getNote().equals(userNotesDTO2.getNote())));
        assertTrue(notesDTOList.stream().anyMatch(note -> note.getId().equals(userNotesDTO3.getId())));
        assertTrue(notesDTOList.stream().anyMatch(note -> note.getDate().equals(userNotesDTO3.getDate())));
        deleteNotes(userNotesDTO2);
        notesDTOList = userNotesController.findAll();
        assertEquals(2, notesDTOList.size());
        assertTrue(notesDTOList.stream().anyMatch(note -> note.getId().equals(userNotesDTO1.getId())));
        assertTrue(notesDTOList.stream().anyMatch(note -> note.getDate().equals(userNotesDTO1.getDate())));
        assertFalse(notesDTOList.stream().anyMatch(note -> note.getId().equals(userNotesDTO2.getId())));
        assertFalse(notesDTOList.stream().anyMatch(note -> note.getNote().equals(userNotesDTO2.getNote())));
        deleteNotes(userNotesDTO1);
        deleteNotes(userNotesDTO3);
        assertTrue(userNotesController.findAll().isEmpty());
    }


    @Test
    public void getUserNotesById() throws Exception {
        UserNotesDTO userNotesDTO11 = userNotesController.addObject(createUserNotesTest(new GregorianCalendar(2012, 8, 12).getTime(), "note11"));
        UserNotesDTO userNotesDTO12 = userNotesController.addObject(createUserNotesTest(new GregorianCalendar().getTime(), "note12"));
        UserNotesDTO userNotesDTO13 = userNotesController.addObject(createUserNotesTest(new GregorianCalendar(1990, 5, 11).getTime(), "note13"));

        UserNotesDTO userNotesDTO21 = userNotesController.addObject(createUserNotesTest2(new GregorianCalendar(2010, 4, 02).getTime(), "note21"));
        UserNotesDTO userNotesDTO22 = userNotesController.addObject(createUserNotesTest2(new GregorianCalendar().getTime(), "note22"));

        List<UserNotesDTO> userNotesDTOListUser1 = userNotesController.getUserNotesByUserId(userDetailsId1);
        assertEquals(3, userNotesDTOListUser1.size());
        assertTrue(userNotesDTOListUser1.stream().anyMatch(note -> note.getId().equals(userNotesDTO11.getId())));
        assertTrue(userNotesDTOListUser1.stream().anyMatch(note -> note.getId().equals(userNotesDTO12.getId())));
        assertTrue(userNotesDTOListUser1.stream().anyMatch(note -> note.getId().equals(userNotesDTO13.getId())));

        List<UserNotesDTO> userNotesDTOListUser2 = userNotesController.getUserNotesByUserId(userDetailsId2);
        assertEquals(2, userNotesDTOListUser2.size());
        assertTrue(userNotesDTOListUser2.stream().anyMatch(note -> note.getId().equals(userNotesDTO21.getId())));
        assertTrue(userNotesDTOListUser2.stream().anyMatch(note -> note.getId().equals(userNotesDTO22.getId())));

        deleteNotes(userNotesDTO11);
        deleteNotes(userNotesDTO21);

        userNotesDTOListUser1 = userNotesController.getUserNotesByUserId(userDetailsId1);
        assertEquals(2, userNotesDTOListUser1.size());

        userNotesDTOListUser2 = userNotesController.getUserNotesByUserId(userDetailsId2);
        assertEquals(1, userNotesDTOListUser2.size());
        deleteNotes(userNotesDTO12);
        deleteNotes(userNotesDTO13);
        deleteNotes(userNotesDTO22);
    }

    @Test
    public void getUserNotesByDate() throws Exception {
        Date date11 = new GregorianCalendar(2012, 8, 12).getTime();
        Date date2 = new GregorianCalendar().getTime();
        Date date13 = new GregorianCalendar(1990, 5, 11).getTime();
        UserNotesDTO userNotesDTO11 = userNotesController.addObject(createUserNotesTest(date11, "note11"));
        UserNotesDTO userNotesDTO12 = userNotesController.addObject(createUserNotesTest(date2, "note12"));
        UserNotesDTO userNotesDTO13 = userNotesController.addObject(createUserNotesTest(date2, "note13ddddddddddd"));
        UserNotesDTO userNotesDTO14 = userNotesController.addObject(createUserNotesTest(date2, "note14new"));
        UserNotesDTO userNotesDTO15 = userNotesController.addObject(createUserNotesTest(date13, "note15"));
        UserNotesDTO userNotesDTO16 = userNotesController.addObject(createUserNotesTest(date13, "note16"));

        Date date21 = new GregorianCalendar(2010, 4, 02).getTime();
        UserNotesDTO userNotesDTO21 = userNotesController.addObject(createUserNotesTest2(date21, "note21"));
        UserNotesDTO userNotesDTO22 = userNotesController.addObject(createUserNotesTest2(date21, "note22"));
        UserNotesDTO userNotesDTO23 = userNotesController.addObject(createUserNotesTest2(date2, "note23"));

        List<UserNotesDTO> userNotesDTOListUser1Date1 = userNotesController.getUserNotesByDate(userDetailsId1, date11);
        assertEquals(1, userNotesDTOListUser1Date1.size());
        assertTrue(userNotesDTOListUser1Date1.stream().anyMatch(note -> note.getId().equals(userNotesDTO11.getId())));

        List<UserNotesDTO> userNotesDTOListUser1Date2 = userNotesController.getUserNotesByDate(userDetailsId1, date2);
        assertEquals(3, userNotesDTOListUser1Date2.size());
        assertTrue(userNotesDTOListUser1Date2.stream().anyMatch(note -> note.getId().equals(userNotesDTO12.getId())));
        assertTrue(userNotesDTOListUser1Date2.stream().anyMatch(note -> note.getId().equals(userNotesDTO13.getId())));
        assertTrue(userNotesDTOListUser1Date2.stream().anyMatch(note -> note.getId().equals(userNotesDTO14.getId())));

        List<UserNotesDTO> userNotesDTOListUser1Date3 = userNotesController.getUserNotesByDate(userDetailsId1, date13);
        assertEquals(2, userNotesDTOListUser1Date3.size());
        assertTrue(userNotesDTOListUser1Date3.stream().anyMatch(note -> note.getId().equals(userNotesDTO15.getId())));
        assertTrue(userNotesDTOListUser1Date3.stream().anyMatch(note -> note.getId().equals(userNotesDTO16.getId())));

        List<UserNotesDTO> userNotesDTOListUser2Date21 = userNotesController.getUserNotesByDate(userDetailsId2, date21);
        assertEquals(2, userNotesDTOListUser2Date21.size());
        assertTrue(userNotesDTOListUser2Date21.stream().anyMatch(note -> note.getId().equals(userNotesDTO21.getId())));
        assertTrue(userNotesDTOListUser2Date21.stream().anyMatch(note -> note.getId().equals(userNotesDTO22.getId())));

        List<UserNotesDTO> userNotesDTOListUser2Date22 = userNotesController.getUserNotesByDate(userDetailsId2, date2);
        assertEquals(1, userNotesDTOListUser2Date22.size());
        assertTrue(userNotesDTOListUser2Date22.stream().anyMatch(note -> note.getId().equals(userNotesDTO23.getId())));

        List<UserNotesDTO> userNotesDTOListUser2DateNew = userNotesController.getUserNotesByDate(userDetailsId2, new GregorianCalendar(1999, 12, 2).getTime());
        assertTrue(userNotesDTOListUser2DateNew.isEmpty());

        deleteNotes(userNotesDTO11);
        deleteNotes(userNotesDTO12);
        deleteNotes(userNotesDTO13);
        deleteNotes(userNotesDTO14);
        deleteNotes(userNotesDTO15);
        deleteNotes(userNotesDTO16);
        deleteNotes(userNotesDTO21);
        deleteNotes(userNotesDTO22);
        deleteNotes(userNotesDTO23);
    }

}