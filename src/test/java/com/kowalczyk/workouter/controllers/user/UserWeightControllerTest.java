package com.kowalczyk.workouter.controllers.user;

import com.kowalczyk.workouter.controllers.AbstractControllerTest;
import com.kowalczyk.workouter.model.DTO.user.impl.UserInfoDTO;
import com.kowalczyk.workouter.model.DTO.user.impl.UserWeightDTO;
import com.kowalczyk.workouter.model.exception.NotFoundException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Created by JK on 2017-04-08.
 */
public class UserWeightControllerTest extends AbstractControllerTest {
    @Autowired
    private UserWeightController userWeightController;

    @Test
    public void getObject() throws Exception {
        UserWeightDTO expectedUserWeightDTO = userWeightController.addObject(getUserWeightDTOTest(54, new GregorianCalendar(2012, 10, 12)));
        UserWeightDTO actualUserWeightDTO = userWeightController.getObject(expectedUserWeightDTO.getId());

        assertTrue(Objects.equals(expectedUserWeightDTO.getId(), actualUserWeightDTO.getId()));
        assertEquals(expectedUserWeightDTO.getDate(), actualUserWeightDTO.getDate());
        assertEquals(1, userWeightController.findAll().size());

        UserWeightDTO expectedUserWeightDTO1 = userWeightController.addObject(getUserWeightDTOTest(60, new GregorianCalendar(2013, 10, 12)));
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

        expectedUserWeightDTO1 = userWeightController.addObject(getUserWeightDTOTest(14, new GregorianCalendar(2012, 3, 2)));
        Long userId = expectedUserWeightDTO1.getUserId();
        userController.deleteObject(userId);
        assertFalse(userController.isExist(expectedUserWeightDTO1.getUserId()));
        assertEquals(0, userWeightController.findAll().size());
    }

    private void deleteWeights(UserWeightDTO expectedUserWeightDTO) {
        userWeightController.deleteObject(expectedUserWeightDTO.getId());
        assertFalse(userWeightController.isExist(expectedUserWeightDTO.getId()));
    }

    @Test
    public void testDelete() throws Exception {
        UserWeightDTO expectedUserWeightDTO = userWeightController.addObject(getUserWeightDTOTest(14, new GregorianCalendar(2012, 3, 2)));
        assertTrue(userWeightController.isExist(expectedUserWeightDTO.getId()));
        deleteWeights(expectedUserWeightDTO);
        assertFalse(userWeightController.isExist(20L));

        UserWeightDTO expectedUserWeightDTO1 = userWeightController.addObject(getUserWeightDTOTest(54, new GregorianCalendar(2012, 10, 12)));
        List<UserWeightDTO> userWeightDTOList = userWeightController.findAll();
        assertEquals(1, userWeightDTOList.size());
        assertTrue(Objects.equals(expectedUserWeightDTO1.getId(), userWeightController.getActualWeight(expectedUserWeightDTO.getUserId()).getId()));

        UserWeightDTO expectedUserWeightDTO2 = userWeightController.addObject(getUserWeightDTOTest(57, new GregorianCalendar(2015, 10, 12)));
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
        UserWeightDTO expectedUserWeightDTO = userWeightController.addObject(getUserWeightDTOTest(14, new GregorianCalendar(2012, 3, 2)));
        UserWeightDTO expectedUserWeightDTO1 = userWeightController.addObject(getUserWeightDTOTest(54, new GregorianCalendar(2013, 10, 12)));

        assertTrue(Objects.equals(expectedUserWeightDTO1.getId(), userWeightController.getActualWeight(expectedUserWeightDTO1.getUserId()).getId()));

        expectedUserWeightDTO.setDate(new GregorianCalendar().getTime());
        UserWeightDTO userWeightDTO = userWeightController.updateObject(expectedUserWeightDTO);
        assertEquals(expectedUserWeightDTO.getDate(), userWeightDTO.getDate());
        assertEquals(expectedUserWeightDTO.getId(), userWeightDTO.getId());

        List<UserWeightDTO> userWeightDTOList = userWeightController.findAll();
        assertEquals(2, userWeightDTOList.size());
        assertTrue(Objects.equals(expectedUserWeightDTO.getId(), userWeightController.getActualWeight(expectedUserWeightDTO.getUserId()).getId()));

        TimeUnit.SECONDS.sleep(1);

        expectedUserWeightDTO1.setDate(new GregorianCalendar().getTime());
        userWeightDTO = userWeightController.updateObject(expectedUserWeightDTO1);
        assertEquals(expectedUserWeightDTO1.getId(), userWeightDTO.getId());
        assertTrue(Objects.equals(expectedUserWeightDTO1.getId(), userWeightController.getActualWeight(expectedUserWeightDTO.getUserId()).getId()));

        TimeUnit.SECONDS.sleep(1);

        UserWeightDTO expectedUserWeightDTO2 = userWeightController.addObject(getUserWeightDTOTest(44, new GregorianCalendar()));
        assertTrue(Objects.equals(expectedUserWeightDTO2.getId(), userWeightController.getActualWeight(expectedUserWeightDTO.getUserId()).getId()));
        userWeightDTOList = userWeightController.findAll();
        assertEquals(3, userWeightDTOList.size());

        deleteWeights(expectedUserWeightDTO2);

        assertEquals(expectedUserWeightDTO1.getId(), userWeightController.getActualWeight(expectedUserWeightDTO.getUserId()).getId());

        deleteWeights(expectedUserWeightDTO);
        deleteWeights(expectedUserWeightDTO1);
        userWeightDTOList = userWeightController.findAll();
        assertEquals(0, userWeightDTOList.size());
    }

    @Test
    public void testFindAll() throws Exception {
        UserWeightDTO expectedUserWeightDTO = userWeightController.addObject(getUserWeightDTOTest(54, new GregorianCalendar(2012, 10, 12)));
        UserWeightDTO expectedUserWeightDTO1 = userWeightController.addObject(getUserWeightDTOTest(14, new GregorianCalendar(2013, 3, 2)));
        List<UserWeightDTO> userWeightDTOList = userWeightController.findAll();
        assertEquals(2, userWeightDTOList.size());
        assertTrue(Objects.equals(expectedUserWeightDTO1.getId(), userWeightController.getActualWeight(expectedUserWeightDTO.getUserId()).getId()));

        UserWeightDTO expectedUserWeightDTO2 = userWeightController.addObject(getUserWeightDTOTest(30, new GregorianCalendar(2015, 3, 2)));
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
        UserWeightDTO expectedUserWeightDTO = getUserWeightDTOTest(14, new GregorianCalendar(2012, 3, 2));
        expectedUserWeightDTO.setDate(new GregorianCalendar().getTime());
        expectedUserWeightDTO = userWeightController.addObject(expectedUserWeightDTO);
        UserWeightDTO expectedUserWeightDTO2 = getUserWeightDTOTest(54, new GregorianCalendar(2012, 10, 12));
        expectedUserWeightDTO2 = userWeightController.addObject(expectedUserWeightDTO2);
        UserWeightDTO userWeightDTO3 = getUserWeightDTOTest(60, new GregorianCalendar(2014, 10, 12));
        userWeightDTO3.setDate(new GregorianCalendar(2012, 12, 3).getTime());
        userWeightDTO3 = userWeightController.addObject(userWeightDTO3);

        List<UserWeightDTO> userWeightDTOS = userWeightController.getWeightByUserId(expectedUserWeightDTO.getUserId());
        assertEquals(3, userWeightDTOS.size());
        assertTrue(expectedUserWeightDTO.getUserId().intValue() == userWeightDTOS.get(2).getUserId());
        UserWeightDTO finalExpectedUserWeightDTO = expectedUserWeightDTO;
        assertTrue(userWeightDTOS.stream().anyMatch(userWeightDTO -> userWeightDTO.getWeightKg().equals(finalExpectedUserWeightDTO.getWeightKg())));

        userWeightDTOS = userWeightController.getWeightByUserId(expectedUserWeightDTO.getUserId());
        assertEquals(3, userWeightDTOS.size());

        userWeightDTOS = userWeightController.getWeightByUserId(userDetailsId2);
        assertTrue(userWeightDTOS.isEmpty());

        deleteWeights(expectedUserWeightDTO);
        deleteWeights(expectedUserWeightDTO2);
        deleteWeights(userWeightDTO3);
    }

    @Test
    public void getWeightByDate() throws Exception {
        UserWeightDTO userWeightDTO = userWeightController.addObject(getUserWeightDTOTest(54, new GregorianCalendar(2012, 10, 12)));
        userWeightDTO = userWeightController.getObject(userWeightDTO.getId());

        UserWeightDTO expectedUserWeightDTO = getUserWeightDTOTest(14, new GregorianCalendar(2012, 3, 2));
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

    @Test
    public void testUserInfoWeight() throws Exception {
        UserWeightDTO userWeightDTO1 = userWeightController.addObject(getUserWeightDTOTest(56, new GregorianCalendar(2012, 12, 3)));
        UserInfoDTO userInfoDTO = userInfoController.getByUserId(userWeightDTO1.getUserId());
        assertEquals(userWeightDTO1.getId(), userInfoDTO.getActualWeightId());

        UserWeightDTO userWeightDTO2 = userWeightController.addObject(getUserWeightDTOTest(59, new GregorianCalendar(2013, 3, 3)));
        UserWeightDTO userWeightDTO3 = userWeightController.addObject(getUserWeightDTOTest(70, new GregorianCalendar(2013, 3, 1)));

        userInfoDTO = userInfoController.getByUserId(userWeightDTO2.getUserId());
        assertEquals(userWeightDTO2.getId(), userInfoDTO.getActualWeightId());

        deleteWeights(userWeightDTO2);
        userInfoDTO = userInfoController.getByUserId(userWeightDTO2.getUserId());
        assertEquals(userWeightDTO3.getId(), userInfoDTO.getActualWeightId());

        deleteWeights(userWeightDTO3);
        userInfoDTO = userInfoController.getByUserId(userWeightDTO1.getUserId());
        assertEquals(userWeightDTO1.getId(), userInfoDTO.getActualWeightId());

        userWeightDTO2 = userWeightController.addObject(getUserWeightDTOTest(59, new GregorianCalendar(2011, 3, 3)));
        userInfoDTO = userInfoController.getByUserId(userWeightDTO1.getUserId());
        assertEquals(userWeightDTO1.getId(), userInfoDTO.getActualWeightId());

        userWeightDTO2.setDate(new GregorianCalendar().getTime());
        userWeightDTO2 = userWeightController.updateObject(userWeightDTO2);
        userInfoDTO = userInfoController.getByUserId(userWeightDTO2.getUserId());
        assertEquals(userWeightDTO2.getId(), userInfoDTO.getActualWeightId());

        deleteWeights(userWeightDTO1);
        deleteWeights(userWeightDTO2);
        userInfoDTO = userInfoController.getByUserId(userWeightDTO2.getUserId());
        assertNull(userInfoDTO.getActualWeightId());
    }

}