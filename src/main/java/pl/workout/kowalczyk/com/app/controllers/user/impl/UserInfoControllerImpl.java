package pl.workout.kowalczyk.com.app.controllers.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.workout.kowalczyk.com.app.controllers.user.UserInfoController;
import pl.workout.kowalczyk.com.app.model.DTO.user.UserInfoDTO;
import pl.workout.kowalczyk.com.app.services.user.UserInfoService;

/**
 * Created by JK on 2017-01-22.
 */
@RestController
public class UserInfoControllerImpl implements UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Override
    public void saveUserInfo(@RequestBody UserInfoDTO userInfo) {
        userInfoService.saveUserInfo(userInfo);
    }

    @Override
    public UserInfoDTO getById(@PathVariable int userId) {
        return userInfoService.getUserInfoDTOByUserId(userId);
    }
}
