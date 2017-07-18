package com.kowalczyk.workouter.controllers;

import com.kowalczyk.workouter.AbstractTestHelper;
import com.kowalczyk.workouter.controllers.security.RoleController;
import com.kowalczyk.workouter.controllers.user.UserDetailsController;
import com.kowalczyk.workouter.controllers.user.UserInfoController;
import com.kowalczyk.workouter.model.DTO.security.RoleDTO;
import com.kowalczyk.workouter.model.DTO.user.UserDetailsDTO;
import com.kowalczyk.workouter.model.DTO.user.impl.UserInfoDTO;
import com.kowalczyk.workouter.model.DTO.user.impl.UserNotesDTO;
import com.kowalczyk.workouter.model.DTO.user.impl.UserWeightDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;

/**
 * Created by JK on 2017-02-01.
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AbstractControllerTest extends AbstractTestHelper {

    protected Long userDetailsId1;
    protected Long userDetailsId2;
    @Autowired
    private UserDetailsController userDetailsController;
    @Autowired
    private RoleController roleController;
    @Autowired
    private UserInfoController userInfoController;

    @Before
    public void setUp() throws Exception {
        roleController.addObject(buildRoleDTOTest());
        addUserDetailsUserInfo1();
        addUserDetailsUserInfo2();
    }

    @After
    public void tearDown() throws Exception {
        List<UserDetailsDTO> userDetailsDTOS = userDetailsController.findAll();
        new ArrayList<>(userDetailsDTOS).forEach(userDetailsDTO -> {
            userDetailsController.deleteObject(userDetailsDTO.getId());
            assertFalse(userDetailsController.isExist(userDetailsDTO.getId()));
        });
        List<RoleDTO> roleDTOS = roleController.findAll();
        new ArrayList<>(roleDTOS).forEach(roleDTO -> {
            roleController.deleteObject(roleDTO.getId());
            assertFalse(roleController.isExist(roleDTO.getId()));
        });
    }

    private void addUserDetailsUserInfo1() {
        UserDetailsDTO userDetailsDTO = getUserDetailsDTOTest();
        userDetailsDTO.setRoles(Stream.of(roleController.findAll().stream().findAny().get().getId()).collect(Collectors.toSet()));
        userDetailsDTO = userDetailsController.addObject(userDetailsDTO);
        userDetailsId1 = userDetailsDTO.getId();
        userInfoController.addObject(getUserInfoDTO(userDetailsDTO.getId()));
    }

    private void addUserDetailsUserInfo2() {
        UserDetailsDTO userDetailsDTO = getUserDetailsDTOTest2();
        userDetailsDTO.setRoles(Stream.of(roleController.findAll().stream().findAny().get().getId()).collect(Collectors.toSet()));
        userDetailsDTO = userDetailsController.addObject(userDetailsDTO);
        userDetailsId2 = userDetailsDTO.getId();
        userInfoController.addObject(getUserInfoDTO(userDetailsDTO.getId()));
    }

    protected UserInfoDTO getUserInfoDTO(Long userId) {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUserId(userId);
        userInfoDTO.setActualWeightId(0L);
        userInfoDTO.setFavouriteExerciseId(0L);
        return userInfoDTO;
    }

    protected UserWeightDTO getUserWeightDTOTest() {
        return getUserWeightDTOTest(56, new GregorianCalendar(2012, 12, 12));
    }

    protected UserWeightDTO getUserWeightDTOTest(int weight, GregorianCalendar date) {
        UserWeightDTO userWeightDTO = new UserWeightDTO();
        userWeightDTO.setDate(date.getTime());
        userWeightDTO.setWeightKg(weight);
        userWeightDTO.setUserId(getUserDetailsDTOTest().getId());
        userWeightDTO.setUserId(userDetailsController.findAll().stream().findFirst().get().getId());
        return userWeightDTO;
    }

    protected UserNotesDTO createUserNotesTest(Date date, String note) {
        UserNotesDTO userNotesDTO = getUserNotesDTOTest(date, note);
        userNotesDTO.setUserId(userDetailsId1);
        return userNotesDTO;
    }

    protected UserNotesDTO createUserNotesTest2(Date date, String note) {
        UserNotesDTO userNotesDTO = getUserNotesDTOTest(date, note);
        userNotesDTO.setUserId(userDetailsId2);
        return userNotesDTO;
    }

    private UserNotesDTO getUserNotesDTOTest(Date date, String note) {
        UserNotesDTO userNotesDTO = new UserNotesDTO();
        userNotesDTO.setDate(date);
        userNotesDTO.setNote(note);
        return userNotesDTO;
    }
}
