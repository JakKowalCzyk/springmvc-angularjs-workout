package com.kowalczyk.workouter.controllers.user;

import com.kowalczyk.workouter.controllers.AbstractControllerTest;
import com.kowalczyk.workouter.model.DTO.user.impl.UserWeightDTO;
import com.kowalczyk.workouter.model.exception.NotFoundException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Created by JK on 2017-04-08.
 */
public class UserWeightControllerTest extends AbstractControllerTest {
    @Autowired
    private UserWeightController userWeightController;

    @Test
    public void getObject() throws Exception {
        UserWeightDTO expectedUserWeightDTO = userWeightController.addObject(getUserWeightDTOTest());
        UserWeightDTO actualUserWeightDTO = userWeightController.getObject(expectedUserWeightDTO.getId());

        assertTrue(Objects.equals(expectedUserWeightDTO.getId(), actualUserWeightDTO.getId()));
        assertEquals(expectedUserWeightDTO.getDate(), actualUserWeightDTO.getDate());
        assertEquals(1, userWeightController.findAll().size());

        UserWeightDTO expectedUserWeightDTO1 = userWeightController.addObject(getUserWeightDTOTest());
        UserWeightDTO userWeightDTO = userWeightController.getObject(expectedUserWeightDTO1.getId());
        assertEquals(2, userWeightController.findAll().size());
        assertTrue(userWeightDTO.getId().equals(expectedUserWeightDTO1.getId()));

        try {
            UserWeightDTO userWeightDTO1 = userWeightController.getObject(50L);
        } catch (Exception e) {
            assertTrue(e instanceof NotFoundException);
        }

        deleteWeights(expectedUserWeightDTO);
        assertEquals(1, userWeightController.findAll().size());
        deleteWeights(expectedUserWeightDTO1);
    }

    private void deleteWeights(UserWeightDTO expectedUserWeightDTO) {
        userWeightController.deleteObject(expectedUserWeightDTO.getId());
        assertFalse(userWeightController.isExist(expectedUserWeightDTO.getId()));
    }

    @Test
    public void testDelete() throws Exception {
        UserWeightDTO expectedUserWeightDTO = userWeightController.addObject(getUserWeightDTOTest());
        assertTrue(userWeightController.isExist(expectedUserWeightDTO.getId()));
        deleteWeights(expectedUserWeightDTO);
        assertFalse(userWeightController.isExist(20L));
        UserWeightDTO expectedUserWeightDTO1 = userWeightController.addObject(getUserWeightDTOTest());
        List<UserWeightDTO> userWeightDTOList = userWeightController.findAll();
        assertEquals(1, userWeightDTOList.size());
        assertTrue(Objects.equals(expectedUserWeightDTO1.getId(), userWeightController.getActualWeight(expectedUserWeightDTO.getUserId()).getId()));
        UserWeightDTO expectedUserWeightDTO2 = userWeightController.addObject(getUserWeightDTOTest());
        assertTrue(Objects.equals(expectedUserWeightDTO2.getId(), userWeightController.getActualWeight(expectedUserWeightDTO.getUserId()).getId()));
        deleteWeights(expectedUserWeightDTO1);
        userWeightDTOList = userWeightController.findAll();
        assertEquals(1, userWeightDTOList.size());
        try {
            userWeightController.getActualWeight(1L).getId();
        } catch (Exception e) {
            assertTrue(e instanceof NotFoundException);
        }
        deleteWeights(expectedUserWeightDTO2);
    }

    @Test
    public void testUpdateActualWeight() throws Exception {
        UserWeightDTO expectedUserWeightDTO = userWeightController.addObject(getUserWeightDTOTest());
        UserWeightDTO expectedUserWeightDTO1 = userWeightController.addObject(getUserWeightDTOTest());
        expectedUserWeightDTO = userWeightController.getObject(expectedUserWeightDTO.getId());
        expectedUserWeightDTO.setDate(new GregorianCalendar().getTime());
        UserWeightDTO userWeightDTO = userWeightController.updateObject(expectedUserWeightDTO);
        assertEquals(expectedUserWeightDTO.getDate(), userWeightDTO.getDate());
        assertEquals(expectedUserWeightDTO.getId(), userWeightDTO.getId());
        List<UserWeightDTO> userWeightDTOList = userWeightController.findAll();
        assertEquals(2, userWeightDTOList.size());
        assertTrue(Objects.equals(expectedUserWeightDTO.getId(), userWeightController.getActualWeight(expectedUserWeightDTO.getUserId()).getId()));
        expectedUserWeightDTO1.setDate(new GregorianCalendar().getTime());
        userWeightDTO = userWeightController.updateObject(expectedUserWeightDTO1);
        assertEquals(expectedUserWeightDTO1.getId(), userWeightDTO.getId());
        assertTrue(Objects.equals(expectedUserWeightDTO1.getId(), userWeightController.getActualWeight(expectedUserWeightDTO.getUserId()).getId()));
        UserWeightDTO newUserWeightDTO1 = getUserWeightDTOTest();
        newUserWeightDTO1.setDate(new GregorianCalendar().getTime());
        UserWeightDTO expectedUserWeightDTO2 = userWeightController.addObject(newUserWeightDTO1);
        assertTrue(Objects.equals(expectedUserWeightDTO2.getId(), userWeightController.getActualWeight(expectedUserWeightDTO.getUserId()).getId()));
        userWeightDTOList = userWeightController.findAll();
        assertEquals(2, userWeightDTOList.size());
        userWeightController.deleteObject(expectedUserWeightDTO.getId());
        userWeightController.deleteObject(expectedUserWeightDTO1.getId());
        userWeightController.deleteObject(expectedUserWeightDTO2.getId());
        assertFalse(userWeightController.isExist(expectedUserWeightDTO.getId()));
        assertFalse(userWeightController.isExist(expectedUserWeightDTO1.getId()));
        assertFalse(userWeightController.isExist(expectedUserWeightDTO2.getId()));
        userWeightDTOList = userWeightController.findAll();
        assertEquals(0, userWeightDTOList.size());
    }

    @Test
    public void testFindAll() throws Exception {
        UserWeightDTO expectedUserWeightDTO = userWeightController.addObject(getUserWeightDTOTest());
        UserWeightDTO expectedUserWeightDTO1 = userWeightController.addObject(getUserWeightDTOTest());
        List<UserWeightDTO> userWeightDTOList = userWeightController.findAll();
        assertEquals(2, userWeightDTOList.size());
        assertTrue(Objects.equals(expectedUserWeightDTO1.getId(), userWeightController.getActualWeight(expectedUserWeightDTO.getUserId()).getId()));
        UserWeightDTO expectedUserWeightDTO2 = userWeightController.addObject(getUserWeightDTOTest());
        userWeightDTOList = userWeightController.findAll();
        assertEquals(3, userWeightDTOList.size());
        assertTrue(Objects.equals(expectedUserWeightDTO2.getId(), userWeightController.getActualWeight(expectedUserWeightDTO.getUserId()).getId()));
        userWeightController.deleteObject(expectedUserWeightDTO2.getId());
        userWeightController.deleteObject(expectedUserWeightDTO1.getId());
        assertTrue(Objects.equals(expectedUserWeightDTO.getId(), userWeightController.getActualWeight(expectedUserWeightDTO.getUserId()).getId()));
        userWeightDTOList = userWeightController.findAll();
        assertEquals(1, userWeightDTOList.size());
        deleteWeights(expectedUserWeightDTO);
        assertFalse(userWeightController.isExist(expectedUserWeightDTO1.getId()));
        assertFalse(userWeightController.isExist(expectedUserWeightDTO2.getId()));
    }

    @Test
    public void getWeightByUserId() throws Exception {
        UserWeightDTO expectedUserWeightDTO = getUserWeightDTOTest();
        expectedUserWeightDTO.setDate(new GregorianCalendar().getTime());
        expectedUserWeightDTO.setId(10L);
        expectedUserWeightDTO = userWeightController.addObject(expectedUserWeightDTO);
        UserWeightDTO expectedUserWeightDTO2 = getUserWeightDTOTest();
        expectedUserWeightDTO2.setUserId(2L);
        expectedUserWeightDTO2 = userWeightController.addObject(expectedUserWeightDTO2);
        userWeightController.addObject(expectedUserWeightDTO2);
        List<UserWeightDTO> userWeightDTOS = userWeightController.getWeightByUserId(1L);
        assertEquals(2, userWeightDTOS.size());
        assertTrue(1L == userWeightDTOS.get(0).getUserId());
        assertEquals(expectedUserWeightDTO.getWeightKg(), userWeightDTOS.get(1).getWeightKg());
        userWeightDTOS = userWeightController.getWeightByUserId(2L);
        assertEquals(1, userWeightDTOS.size());
        userWeightController.deleteObject(1L);
        userWeightController.deleteObject(2L);
        userWeightController.deleteObject(3L);
        assertFalse(userWeightController.isExist(1L));
        assertFalse(userWeightController.isExist(2L));
    }

    @Test
    public void getWeightByDate() throws Exception {
        userWeightController.addObject(getUserWeightDTOTest());
        UserWeightDTO userWeightDTO = userWeightController.getObject(1L);
        UserWeightDTO expectedUserWeightDTO = getUserWeightDTOTest();
        expectedUserWeightDTO.setDate(new GregorianCalendar().getTime());
        expectedUserWeightDTO.setId(10L);
        userWeightController.addObject(expectedUserWeightDTO);
        expectedUserWeightDTO = userWeightController.getWeightByDate(1L, userWeightDTO.getDate());
        assertEquals(userWeightDTO.getId(), expectedUserWeightDTO.getId());
        try {
            expectedUserWeightDTO = userWeightController.getWeightByDate(4L, userWeightDTO.getDate());
        } catch (Exception e) {
            assertTrue(e instanceof NotFoundException);
        }
        userWeightController.deleteObject(2L);
        userWeightController.deleteObject(1L);
        assertFalse(userWeightController.isExist(1L));
        assertFalse(userWeightController.isExist(2L));
    }


}