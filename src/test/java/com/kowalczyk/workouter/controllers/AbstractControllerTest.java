package com.kowalczyk.workouter.controllers;

import com.kowalczyk.workouter.AbstractTestHelper;
import com.kowalczyk.workouter.controllers.security.RoleController;
import com.kowalczyk.workouter.controllers.user.UserDetailsController;
import com.kowalczyk.workouter.controllers.user.UserInfoController;
import com.kowalczyk.workouter.model.DTO.security.RoleDTO;
import com.kowalczyk.workouter.model.DTO.user.UserDetailsDTO;
import com.kowalczyk.workouter.model.DTO.user.impl.UserInfoDTO;
import com.kowalczyk.workouter.model.DTO.user.impl.UserWeightDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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
        userDetailsDTOS.forEach(userDetailsDTO -> {
            userDetailsController.deleteObject(userDetailsDTO.getId());
            assertFalse(userDetailsController.isExist(userDetailsDTO.getId()));
        });
        List<RoleDTO> roleDTOS = roleController.findAll();
        roleDTOS.forEach(roleDTO -> {
            roleController.deleteObject(roleDTO.getId());
            assertFalse(roleController.isExist(roleDTO.getId()));
        });
    }

    private void addUserDetailsUserInfo2() {
        UserDetailsDTO userDetailsDTO = getUserDetailsDTOTest2();
        userDetailsDTO.setRoles(Stream.of(roleController.findAll().stream().findAny().get().getId()).collect(Collectors.toSet()));
        userDetailsDTO = userDetailsController.addObject(userDetailsDTO);
        userInfoController.addObject(getUserInfoDTO(userDetailsDTO.getId()));
    }

    private void addUserDetailsUserInfo1() {
        UserDetailsDTO userDetailsDTO = getUserDetailsDTOTest();
        userDetailsDTO.setRoles(Stream.of(roleController.findAll().stream().findAny().get().getId()).collect(Collectors.toSet()));
        userDetailsDTO = userDetailsController.addObject(userDetailsDTO);
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
        UserWeightDTO userWeightDTO = buildUserWeightDTOTest();
        userWeightDTO.setUserId(userDetailsController.findAll().stream().findFirst().get().getId());
        return userWeightDTO;
    }
}
