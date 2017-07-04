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
    @Autowired
    private UserDetailsController userDetailsController;

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

        expectedUserWeightDTO1 = userWeightController.addObject(getUserWeightDTOTest());
        userDetailsController.deleteObject(expectedUserWeightDTO1.getUserId());
        assertEquals(0, userWeightController.findAll().size());
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
            userWeightController.getActualWeight(expectedUserWeightDTO.getUserId()).getId();
        } catch (Exception e) {
            assertTrue(e instanceof NotFoundException);
        }
        deleteWeights(expectedUserWeightDTO2);
        userWeightDTOList = userWeightController.findAll();
        assertEquals(0, userWeightDTOList.size());
    }

    @Test
    public void testUpdateActualWeight() throws Exception {
        UserWeightDTO expectedUserWeightDTO = userWeightController.addObject(getUserWeightDTOTest());
        UserWeightDTO expectedUserWeightDTO1 = userWeightController.addObject(getUserWeightDTOTest());

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
        assertEquals(3, userWeightDTOList.size());

        deleteWeights(expectedUserWeightDTO2);

        assertTrue(Objects.equals(expectedUserWeightDTO1.getId(), userWeightController.getActualWeight(expectedUserWeightDTO.getUserId()).getId()));

        deleteWeights(expectedUserWeightDTO);
        deleteWeights(expectedUserWeightDTO1);
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

        deleteWeights(expectedUserWeightDTO2);
        deleteWeights(expectedUserWeightDTO1);
        assertTrue(Objects.equals(expectedUserWeightDTO.getId(), userWeightController.getActualWeight(expectedUserWeightDTO.getUserId()).getId()));
        userWeightDTOList = userWeightController.findAll();
        assertEquals(1, userWeightDTOList.size());
        deleteWeights(expectedUserWeightDTO);
    }

    @Test
    public void getWeightByUserId() throws Exception {
        UserWeightDTO expectedUserWeightDTO = getUserWeightDTOTest();
        expectedUserWeightDTO.setDate(new GregorianCalendar().getTime());
        expectedUserWeightDTO = userWeightController.addObject(expectedUserWeightDTO);
        UserWeightDTO expectedUserWeightDTO2 = getUserWeightDTOTest();
        expectedUserWeightDTO2 = userWeightController.addObject(expectedUserWeightDTO2);
        UserWeightDTO userWeightDTO3 = getUserWeightDTOTest();
        userWeightDTO3.setDate(new GregorianCalendar(2012, 12, 3).getTime());
        userWeightDTO3 = userWeightController.addObject(userWeightDTO3);

        List<UserWeightDTO> userWeightDTOS = userWeightController.getWeightByUserId(expectedUserWeightDTO.getUserId());
        assertEquals(3, userWeightDTOS.size());
        assertTrue(expectedUserWeightDTO.getUserId().intValue() == userWeightDTOS.get(2).getUserId());
        assertEquals(expectedUserWeightDTO.getWeightKg(), userWeightDTOS.get(1).getWeightKg());
        userWeightDTOS = userWeightController.getWeightByUserId(expectedUserWeightDTO.getUserId());
        assertEquals(3, userWeightDTOS.size());
        deleteWeights(expectedUserWeightDTO);
        deleteWeights(expectedUserWeightDTO2);
        deleteWeights(userWeightDTO3);
    }

    @Test
    public void getWeightByDate() throws Exception {
        UserWeightDTO userWeightDTO = userWeightController.addObject(getUserWeightDTOTest());
        userWeightDTO = userWeightController.getObject(userWeightDTO.getId());

        UserWeightDTO expectedUserWeightDTO = getUserWeightDTOTest();
        expectedUserWeightDTO.setDate(new GregorianCalendar().getTime());
        UserWeightDTO userWeightDTO1 = userWeightController.addObject(expectedUserWeightDTO);

        expectedUserWeightDTO = userWeightController.getWeightByDate(userWeightDTO.getUserId(), userWeightDTO.getDate());
        assertEquals(userWeightDTO.getId(), expectedUserWeightDTO.getId());
        expectedUserWeightDTO = userWeightController.getWeightByDate(userWeightDTO.getUserId(), userWeightDTO1.getDate());
        assertEquals(userWeightDTO1.getId(), expectedUserWeightDTO.getId());
        try {
            expectedUserWeightDTO = userWeightController.getWeightByDate(0L, userWeightDTO.getDate());
        } catch (Exception e) {
            assertTrue(e instanceof NotFoundException);
        }
        deleteWeights(userWeightDTO);
        deleteWeights(userWeightDTO1);
    }


}