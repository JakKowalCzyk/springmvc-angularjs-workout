package com.kowalczyk.workouter.controllers.user;

import com.kowalczyk.workouter.controllers.AbstractControllerTest;
import com.kowalczyk.workouter.controllers.exercise.ExerciseController;
import com.kowalczyk.workouter.enums.ExerciseType;
import com.kowalczyk.workouter.model.DTO.exercise.ExerciseDTO;
import com.kowalczyk.workouter.model.DTO.user.impl.UserInfoDTO;
import com.kowalczyk.workouter.model.DTO.user.impl.UserWeightDTO;
import com.kowalczyk.workouter.model.exception.NotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by JK on 2017-07-18.
 */
public class UserInfoControllerTest extends AbstractControllerTest {

    @Autowired
    private UserInfoController userInfoController;
    @Autowired
    private UserWeightController userWeightController;
    @Autowired
    private ExerciseController exerciseController;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        userInfoController.findAll().forEach(userInfoDTO -> userInfoController.deleteObject(userInfoDTO.getId()));
    }

    @Test
    public void getObject() throws Exception {
        ExerciseDTO exerciseDTO = exerciseController.addObject(createExerciseDTOTest("ex1", "ex1", ExerciseType.ARMS));
        UserInfoDTO userInfoDTO = getUserInfoDTO(userDetailsId1);
        userInfoDTO.setFavouriteExerciseId(exerciseDTO.getId());
        userInfoDTO = userInfoController.addObject(userInfoDTO);
        UserWeightDTO userWeightDTO = userWeightController.addObject(getUserWeightDTOTest());

        UserInfoDTO userInfoDTO1 = userInfoController.getObject(userInfoDTO.getId());
        assertEquals(userInfoDTO.getId(), userInfoDTO1.getId());
        assertEquals(userInfoDTO.getFavouriteExerciseId(), userInfoDTO1.getFavouriteExerciseId());
        assertEquals(userWeightDTO.getId(), userInfoDTO1.getActualWeightId());
        deleteUserInfo(userInfoDTO);
    }

    private void deleteUserInfo(UserInfoDTO userInfoDTO) {
        userInfoController.deleteObject(userInfoDTO.getId());
        assertFalse(userInfoController.isExist(userInfoDTO.getId()));
    }

    @Test
    public void updateObject() throws Exception {
        ExerciseDTO exerciseDTO = exerciseController.addObject(createExerciseDTOTest("ex1", "ex1", ExerciseType.ARMS));
        ExerciseDTO exerciseDTO1 = exerciseController.addObject(createExerciseDTOTest("ex2", "ex2", ExerciseType.BACK));
        UserInfoDTO userInfoDTO = getUserInfoDTO(userDetailsId1);
        userInfoDTO.setFavouriteExerciseId(exerciseDTO.getId());
        userInfoDTO = userInfoController.addObject(userInfoDTO);
        UserWeightDTO userWeightDTO = userWeightController.addObject(getUserWeightDTOTest());

        userInfoDTO.setFavouriteExerciseId(exerciseDTO1.getId());
        userInfoDTO = userInfoController.updateObject(userInfoDTO);
        assertEquals(userInfoDTO.getFavouriteExerciseId(), exerciseDTO1.getId());

        UserWeightDTO userWeightDTO1 = userWeightController.addObject(getUserWeightDTOTest(100, new GregorianCalendar()));
        userInfoDTO = userInfoController.getObject(userInfoDTO.getId());
        assertEquals(userWeightDTO1.getId(), userInfoDTO.getActualWeightId());
        deleteUserInfo(userInfoDTO);
        assertTrue(userInfoController.findAll().isEmpty());
    }

    @Test
    public void findAll() throws Exception {
        ExerciseDTO exerciseDTO1 = exerciseController.addObject(createExerciseDTOTest("ex1", "ex1", ExerciseType.ARMS));
        ExerciseDTO exerciseDTO2 = exerciseController.addObject(createExerciseDTOTest("ex2", "ex2", ExerciseType.BACK));
        UserInfoDTO userInfoDTO1 = getUserInfoDTO(userDetailsId1);
        UserInfoDTO userInfoDTO2 = getUserInfoDTO(userDetailsId2);
        userInfoDTO1.setFavouriteExerciseId(exerciseDTO1.getId());
        userInfoDTO2.setFavouriteExerciseId(exerciseDTO2.getId());

        userInfoDTO1 = userInfoController.addObject(userInfoDTO1);
        userInfoDTO2 = userInfoController.addObject(userInfoDTO2);


        List<UserInfoDTO> userInfoDTOList = userInfoController.findAll();
        assertEquals(2, userInfoDTOList.size());

        deleteUserInfo(userInfoDTO1);
        userInfoDTOList = userInfoController.findAll();
        assertEquals(1, userInfoDTOList.size());

        deleteUserInfo(userInfoDTO2);
        assertTrue(userInfoController.findAll().isEmpty());
    }

    @Test
    public void getByUserId() throws Exception {
        ExerciseDTO exerciseDTO1 = exerciseController.addObject(createExerciseDTOTest("ex1", "ex1", ExerciseType.ARMS));
        ExerciseDTO exerciseDTO2 = exerciseController.addObject(createExerciseDTOTest("ex2", "ex2", ExerciseType.BACK));
        UserInfoDTO userInfoDTO1 = getUserInfoDTO(userDetailsId1);
        UserInfoDTO userInfoDTO2 = getUserInfoDTO(userDetailsId2);
        userInfoDTO1.setFavouriteExerciseId(exerciseDTO1.getId());
        userInfoDTO2.setFavouriteExerciseId(exerciseDTO2.getId());

        userInfoDTO1 = userInfoController.addObject(userInfoDTO1);
        userInfoDTO2 = userInfoController.addObject(userInfoDTO2);

        UserInfoDTO userInfoDTOUser1 = userInfoController.getByUserId(userDetailsId1);
        assertEquals(userInfoDTO1.getId(), userInfoDTOUser1.getId());
        assertEquals(userInfoDTO1.getFavouriteExerciseId(), userInfoDTOUser1.getFavouriteExerciseId());

        UserInfoDTO userInfoDTOUser2 = userInfoController.getByUserId(userDetailsId2);
        assertEquals(userInfoDTO2.getId(), userInfoDTOUser2.getId());
        assertEquals(userInfoDTO2.getFavouriteExerciseId(), userInfoDTOUser2.getFavouriteExerciseId());

        deleteUserInfo(userInfoDTO1);

        try {
            userInfoDTOUser1 = userInfoController.getByUserId(userDetailsId1);
        } catch (Exception e) {
            assertTrue(e instanceof NotFoundException);
        }
        try {
            userInfoDTOUser1 = userInfoController.getByUserId(10L);
        } catch (Exception e) {
            assertTrue(e instanceof NotFoundException);
        }

        deleteUserInfo(userInfoDTO2);
        assertTrue(userInfoController.findAll().isEmpty());
    }

}