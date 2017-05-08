package com.kowalczyk.workouter.controllers.user;

import com.kowalczyk.workouter.controllers.AbstractControllerTest;
import com.kowalczyk.workouter.model.DTO.user.impl.UserWeightDTO;
import com.kowalczyk.workouter.model.exception.NotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by JK on 2017-04-08.
 */
public class UserWeightControllerTest extends AbstractControllerTest {
    @Autowired
    private UserWeightController userWeightController;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        UserWeightDTO expectedUserWeightDTO = buildUserWeightDTOTest();
        expectedUserWeightDTO = userWeightController.addObject(expectedUserWeightDTO);
    }

    @Test
    public void getObject() throws Exception {
        UserWeightDTO expectedUserWeightDTO = buildUserWeightDTOTest();
        UserWeightDTO actualUserWeightDTO = userWeightController.getObject(1L);
        assertTrue(1 == actualUserWeightDTO.getId());
        assertEquals(expectedUserWeightDTO.getDate(), actualUserWeightDTO.getDate());

        expectedUserWeightDTO.setDate(new GregorianCalendar().getTime());
        expectedUserWeightDTO.setId(10L);
        expectedUserWeightDTO = userWeightController.addObject(expectedUserWeightDTO);
        UserWeightDTO userWeightDTO = userWeightController.getObject(2L);
        assertTrue(2 == expectedUserWeightDTO.getId());
        assertTrue(2 == userWeightDTO.getId());
        try {
            UserWeightDTO userWeightDTO1 = userWeightController.getObject(5L);
        } catch (Exception e) {
            assertTrue(e instanceof NotFoundException);
        }

        testFindAll();

        testUpdateActualWeight();

        testDelete();
    }

    private void testDelete() {
        userWeightController.deleteObject(1L);
        List<UserWeightDTO> userWeightDTOList = userWeightController.findAll();
        assertEquals(1, userWeightDTOList.size());
        assertTrue(2 == userWeightController.getActualWeight(getUserDetailsDTOTest().getId()).getId());
        userWeightController.deleteObject(2L);
        userWeightDTOList = userWeightController.findAll();
        assertEquals(0, userWeightDTOList.size());
        try {
            userWeightController.getActualWeight(getUserDetailsDTOTest().getId()).getId();
        } catch (Exception e) {
            assertTrue(e instanceof NotFoundException);
        }
    }

    private void testUpdateActualWeight() {
        UserWeightDTO expectedUserWeightDTO;
        UserWeightDTO userWeightDTO;
        expectedUserWeightDTO = userWeightController.getObject(1L);
        expectedUserWeightDTO.setDate(new GregorianCalendar().getTime());
        userWeightDTO = userWeightController.updateObject(expectedUserWeightDTO);
        assertEquals(expectedUserWeightDTO.getDate(), userWeightDTO.getDate());
        assertEquals(expectedUserWeightDTO.getId(), userWeightDTO.getId());
        List<UserWeightDTO> userWeightDTOList = userWeightController.findAll();
        assertEquals(2, userWeightDTOList.size());
        assertTrue(1 == userWeightController.getActualWeight(getUserDetailsDTOTest().getId()).getId());
    }

    private void testFindAll() {
        List<UserWeightDTO> userWeightDTOList = userWeightController.findAll();
        assertEquals(2, userWeightDTOList.size());
        assertTrue(2 == userWeightController.getActualWeight(getUserDetailsDTOTest().getId()).getId());
    }

    @Test
    public void getWeightByUserId() throws Exception {
        UserWeightDTO expectedUserWeightDTO = buildUserWeightDTOTest();
        expectedUserWeightDTO.setDate(new GregorianCalendar().getTime());
        expectedUserWeightDTO.setId(10L);
        expectedUserWeightDTO = userWeightController.addObject(expectedUserWeightDTO);
        UserWeightDTO expectedUserWeightDTO2 = buildUserWeightDTOTest();
        expectedUserWeightDTO2.setUserId(2L);
        expectedUserWeightDTO2 = userWeightController.addObject(expectedUserWeightDTO2);
        userWeightController.addObject(expectedUserWeightDTO2);
        List<UserWeightDTO> userWeightDTOS = userWeightController.getWeightByUserId(1L);
        assertEquals(2, userWeightDTOS.size());
        assertTrue(1L == userWeightDTOS.get(0).getUserId());
        assertEquals(expectedUserWeightDTO.getWeightKg(), userWeightDTOS.get(1).getWeightKg());
        userWeightDTOS = userWeightController.getWeightByUserId(2L);
        assertEquals(1, userWeightDTOS.size());
    }

    @Test
    public void getWeightByDate() throws Exception {
        UserWeightDTO userWeightDTO = userWeightController.getObject(1L);
        UserWeightDTO expectedUserWeightDTO = buildUserWeightDTOTest();
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
    }


}