package pl.workout.kowalczyk.com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.workout.kowalczyk.com.app.model.data.dao.UserInfoDao;
import pl.workout.kowalczyk.com.app.model.data.entity.UserInfo;
import pl.workout.kowalczyk.com.app.services.service.UserInfoService;

/**
 * Created by JK on 2016-10-31.
 */
@RestController
@RequestMapping(value = "/user/info")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity saveUserInfo(@RequestBody UserInfo userInfo) {
        userInfoService.saveUserInfo(userInfo);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateUserInfo(@RequestBody UserInfo userInfo) {
        userInfoService.updateUserInfo(userInfo);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public UserInfo getById(@PathVariable int userId) {
        return userInfoService.getUserInfoByUserId(userId);
    }
}
