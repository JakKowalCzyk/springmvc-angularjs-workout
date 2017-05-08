package com.kowalczyk.workouter.controllers;

import com.kowalczyk.workouter.AbstractTestHelper;
import com.kowalczyk.workouter.controllers.security.RoleController;
import com.kowalczyk.workouter.controllers.user.UserDetailsController;
import com.kowalczyk.workouter.controllers.user.UserInfoController;
import com.kowalczyk.workouter.model.DTO.user.impl.UserInfoDTO;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by JK on 2017-02-01.
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
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

    private void addUserDetailsUserInfo2() {
        userDetailsController.addObject(getUserDetailsDTOTest2());
        userInfoController.addObject(getUserInfoDTO(2L));
    }

    private void addUserDetailsUserInfo1() {
        userDetailsController.addObject(buildUserDetailsDTOTest());
        userInfoController.addObject(getUserInfoDTO(1L));
    }

    protected UserInfoDTO getUserInfoDTO(Long userId) {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUserId(userId);
        userInfoDTO.setActualWeightId(0L);
        userInfoDTO.setFavouriteExerciseId(0L);
        return userInfoDTO;
    }
}
