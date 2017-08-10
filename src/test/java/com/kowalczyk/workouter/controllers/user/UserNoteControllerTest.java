package com.kowalczyk.workouter.controllers.user;

import com.kowalczyk.workouter.controllers.AbstractControllerTest;
import com.kowalczyk.workouter.model.DTO.user.impl.UserNoteDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by JK on 2017-07-12.
 */
public class UserNoteControllerTest extends AbstractControllerTest {

    @Autowired
    private UserNotesController userNotesController;

    @Test
    public void getObject() throws Exception {
        UserNoteDTO userNoteDTO = userNotesController.addObject(createUserNotesTest(new GregorianCalendar().getTime(), "note1", userDetailsId1));
        UserNoteDTO expectedUserNoteDTO = userNotesController.getObject(userNoteDTO.getId());
        assertEquals(expectedUserNoteDTO.getDate(), userNoteDTO.getDate());
        deleteNotes(userNoteDTO);

        userNoteDTO = userNotesController.addObject(createUserNotesTest(new GregorianCalendar().getTime(), "note11", userDetailsId1));
        UserNoteDTO userNotesDT12 = userNotesController.addObject(createUserNotesTest(new GregorianCalendar().getTime(), "note12", userDetailsId1));
        UserNoteDTO userNoteDTO2 = userNotesController.addObject(createUserNotesTest(new GregorianCalendar().getTime(), "note2", userDetailsId2));
        userDetailsController.deleteObject(userNoteDTO.getUserId());
        userDetailsController.deleteObject(userNoteDTO2.getUserId());
        assertFalse(userDetailsController.isExist(userNoteDTO2.getUserId()));
        assertEquals(0, userNotesController.findAll().size());
    }

    private void deleteNotes(UserNoteDTO userNoteDTO) {
        userNotesController.deleteObject(userNoteDTO.getId());
        assertFalse(userNotesController.isExist(userNoteDTO.getId()));
    }

    @Test
    public void updateObject() throws Exception {
        UserNoteDTO userNoteDTO = userNotesController.addObject(createUserNotesTest(new GregorianCalendar(2012, 8, 12).getTime(), "note1", userDetailsId1));
        UserNoteDTO userNoteDTO1 = userNotesController.getObject(userNoteDTO.getId());
        userNoteDTO1.setDate(new GregorianCalendar(2021, 1, 11).getTime());
        userNoteDTO1.setNote("new note");
        userNoteDTO = userNotesController.updateObject(userNoteDTO1);
        assertEquals(userNoteDTO1.getId(), userNoteDTO.getId());
        assertEquals(userNoteDTO1.getDate(), userNoteDTO.getDate());
        assertEquals(userNoteDTO1.getNote(), userNoteDTO.getNote());
        deleteNotes(userNoteDTO);
        assertTrue(userNotesController.findAll().isEmpty());
    }

    @Test
    public void findAll() throws Exception {
        UserNoteDTO userNoteDTO1 = userNotesController.addObject(createUserNotesTest(new GregorianCalendar(2012, 8, 12).getTime(), "note1", userDetailsId1));
        UserNoteDTO userNoteDTO2 = userNotesController.addObject(createUserNotesTest(new GregorianCalendar().getTime(), "note2", userDetailsId1));
        UserNoteDTO userNoteDTO3 = userNotesController.addObject(createUserNotesTest(new GregorianCalendar(1990, 5, 11).getTime(), "note3", userDetailsId2));
        List<UserNoteDTO> notesDTOList = userNotesController.findAll();
        assertEquals(3, notesDTOList.size());
        assertTrue(notesDTOList.stream().anyMatch(note -> note.getId().equals(userNoteDTO1.getId())));
        assertTrue(notesDTOList.stream().anyMatch(note -> note.getDate().equals(userNoteDTO1.getDate())));
        assertTrue(notesDTOList.stream().anyMatch(note -> note.getId().equals(userNoteDTO2.getId())));
        assertTrue(notesDTOList.stream().anyMatch(note -> note.getNote().equals(userNoteDTO2.getNote())));
        assertTrue(notesDTOList.stream().anyMatch(note -> note.getId().equals(userNoteDTO3.getId())));
        assertTrue(notesDTOList.stream().anyMatch(note -> note.getDate().equals(userNoteDTO3.getDate())));
        deleteNotes(userNoteDTO2);
        notesDTOList = userNotesController.findAll();
        assertEquals(2, notesDTOList.size());
        assertTrue(notesDTOList.stream().anyMatch(note -> note.getId().equals(userNoteDTO1.getId())));
        assertTrue(notesDTOList.stream().anyMatch(note -> note.getDate().equals(userNoteDTO1.getDate())));
        assertFalse(notesDTOList.stream().anyMatch(note -> note.getId().equals(userNoteDTO2.getId())));
        assertFalse(notesDTOList.stream().anyMatch(note -> note.getNote().equals(userNoteDTO2.getNote())));
        deleteNotes(userNoteDTO1);
        deleteNotes(userNoteDTO3);
        assertTrue(userNotesController.findAll().isEmpty());
    }


    @Test
    public void getUserNotesById() throws Exception {
        UserNoteDTO userNoteDTO11 = userNotesController.addObject(createUserNotesTest(new GregorianCalendar(2012, 8, 12).getTime(), "note11", userDetailsId1));
        UserNoteDTO userNoteDTO12 = userNotesController.addObject(createUserNotesTest(new GregorianCalendar().getTime(), "note12", userDetailsId1));
        UserNoteDTO userNoteDTO13 = userNotesController.addObject(createUserNotesTest(new GregorianCalendar(1990, 5, 11).getTime(), "note13", userDetailsId1));

        UserNoteDTO userNoteDTO21 = userNotesController.addObject(createUserNotesTest(new GregorianCalendar(2010, 4, 02).getTime(), "note21", userDetailsId2));
        UserNoteDTO userNoteDTO22 = userNotesController.addObject(createUserNotesTest(new GregorianCalendar().getTime(), "note22", userDetailsId2));

        List<UserNoteDTO> userNotesDTOListUser1 = userNotesController.getUserNotesByUserId(userDetailsId1);
        assertEquals(3, userNotesDTOListUser1.size());
        assertTrue(userNotesDTOListUser1.stream().anyMatch(note -> note.getId().equals(userNoteDTO11.getId())));
        assertTrue(userNotesDTOListUser1.stream().anyMatch(note -> note.getId().equals(userNoteDTO12.getId())));
        assertTrue(userNotesDTOListUser1.stream().anyMatch(note -> note.getId().equals(userNoteDTO13.getId())));

        List<UserNoteDTO> userNotesDTOListUser2 = userNotesController.getUserNotesByUserId(userDetailsId2);
        assertEquals(2, userNotesDTOListUser2.size());
        assertTrue(userNotesDTOListUser2.stream().anyMatch(note -> note.getId().equals(userNoteDTO21.getId())));
        assertTrue(userNotesDTOListUser2.stream().anyMatch(note -> note.getId().equals(userNoteDTO22.getId())));

        deleteNotes(userNoteDTO11);
        deleteNotes(userNoteDTO21);

        userNotesDTOListUser1 = userNotesController.getUserNotesByUserId(userDetailsId1);
        assertEquals(2, userNotesDTOListUser1.size());

        userNotesDTOListUser2 = userNotesController.getUserNotesByUserId(userDetailsId2);
        assertEquals(1, userNotesDTOListUser2.size());
        deleteNotes(userNoteDTO12);
        deleteNotes(userNoteDTO13);
        deleteNotes(userNoteDTO22);
    }

    @Test
    public void getUserNotesByDate() throws Exception {
        Date date11 = new GregorianCalendar(2012, 8, 12).getTime();
        Date date2 = new GregorianCalendar().getTime();
        Date date13 = new GregorianCalendar(1990, 5, 11).getTime();
        UserNoteDTO userNoteDTO11 = userNotesController.addObject(createUserNotesTest(date11, "note11", userDetailsId1));
        UserNoteDTO userNoteDTO12 = userNotesController.addObject(createUserNotesTest(date2, "note12", userDetailsId1));
        UserNoteDTO userNoteDTO13 = userNotesController.addObject(createUserNotesTest(date2, "note13ddddddddddd", userDetailsId1));
        UserNoteDTO userNoteDTO14 = userNotesController.addObject(createUserNotesTest(date2, "note14new", userDetailsId1));
        UserNoteDTO userNoteDTO15 = userNotesController.addObject(createUserNotesTest(date13, "note15", userDetailsId1));
        UserNoteDTO userNoteDTO16 = userNotesController.addObject(createUserNotesTest(date13, "note16", userDetailsId1));

        Date date21 = new GregorianCalendar(2010, 4, 02).getTime();
        UserNoteDTO userNoteDTO21 = userNotesController.addObject(createUserNotesTest(date21, "note21", userDetailsId2));
        UserNoteDTO userNoteDTO22 = userNotesController.addObject(createUserNotesTest(date21, "note22", userDetailsId2));
        UserNoteDTO userNoteDTO23 = userNotesController.addObject(createUserNotesTest(date2, "note23", userDetailsId2));

        List<UserNoteDTO> userNotesDTOListUser1Date1 = userNotesController.getUserNotesByDate(userDetailsId1, date11);
        assertEquals(1, userNotesDTOListUser1Date1.size());
        assertTrue(userNotesDTOListUser1Date1.stream().anyMatch(note -> note.getId().equals(userNoteDTO11.getId())));

        List<UserNoteDTO> userNotesDTOListUser1Date2 = userNotesController.getUserNotesByDate(userDetailsId1, date2);
        assertEquals(3, userNotesDTOListUser1Date2.size());
        assertTrue(userNotesDTOListUser1Date2.stream().anyMatch(note -> note.getId().equals(userNoteDTO12.getId())));
        assertTrue(userNotesDTOListUser1Date2.stream().anyMatch(note -> note.getId().equals(userNoteDTO13.getId())));
        assertTrue(userNotesDTOListUser1Date2.stream().anyMatch(note -> note.getId().equals(userNoteDTO14.getId())));

        List<UserNoteDTO> userNotesDTOListUser1Date3 = userNotesController.getUserNotesByDate(userDetailsId1, date13);
        assertEquals(2, userNotesDTOListUser1Date3.size());
        assertTrue(userNotesDTOListUser1Date3.stream().anyMatch(note -> note.getId().equals(userNoteDTO15.getId())));
        assertTrue(userNotesDTOListUser1Date3.stream().anyMatch(note -> note.getId().equals(userNoteDTO16.getId())));

        List<UserNoteDTO> userNotesDTOListUser2Date21 = userNotesController.getUserNotesByDate(userDetailsId2, date21);
        assertEquals(2, userNotesDTOListUser2Date21.size());
        assertTrue(userNotesDTOListUser2Date21.stream().anyMatch(note -> note.getId().equals(userNoteDTO21.getId())));
        assertTrue(userNotesDTOListUser2Date21.stream().anyMatch(note -> note.getId().equals(userNoteDTO22.getId())));

        List<UserNoteDTO> userNotesDTOListUser2Date22 = userNotesController.getUserNotesByDate(userDetailsId2, date2);
        assertEquals(1, userNotesDTOListUser2Date22.size());
        assertTrue(userNotesDTOListUser2Date22.stream().anyMatch(note -> note.getId().equals(userNoteDTO23.getId())));

        List<UserNoteDTO> userNotesDTOListUser2DateNew = userNotesController.getUserNotesByDate(userDetailsId2, new GregorianCalendar(1999, 12, 2).getTime());
        assertTrue(userNotesDTOListUser2DateNew.isEmpty());

        deleteNotes(userNoteDTO11);
        deleteNotes(userNoteDTO12);
        deleteNotes(userNoteDTO13);
        deleteNotes(userNoteDTO14);
        deleteNotes(userNoteDTO15);
        deleteNotes(userNoteDTO16);
        deleteNotes(userNoteDTO21);
        deleteNotes(userNoteDTO22);
        deleteNotes(userNoteDTO23);
    }

}