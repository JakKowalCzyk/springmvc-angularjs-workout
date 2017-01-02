package pl.workout.kowalczyk.com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.workout.kowalczyk.com.app.model.DTO.user.UserInfoDTO;
import pl.workout.kowalczyk.com.app.services.user.UserInfoService;

/**
 * Created by JK on 2016-10-31.
 */
@RestController
@RequestMapping(value = "/user/info")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity saveUserInfo(@RequestBody UserInfoDTO userInfo) {
        userInfoService.saveUserInfo(userInfo);
        return new ResponseEntity(HttpStatus.OK);
    }



    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public UserInfoDTO getById(@PathVariable int userId) {
        return userInfoService.getUserInfoDTOByUserId(userId);
    }
}
