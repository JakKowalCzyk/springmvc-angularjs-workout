package pl.workout.kowalczyk.com.app.controllers.user;

/**
 * Created by JK on 2017-01-22.
 */

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.workout.kowalczyk.com.app.model.DTO.user.UserInfoDTO;

@Api(tags = {"User Info API"}, description = "Services for user info")
@RequestMapping("/user/info")
public interface UserInfoController {

    @ApiOperation(value = "Save new User info")
    @RequestMapping(method = RequestMethod.POST)
    void saveUserInfo(@RequestBody UserInfoDTO userInfo);

    @ApiOperation(value = "Get User info for user")
    @RequestMapping(value = "user/{userId}", method = RequestMethod.GET)
    UserInfoDTO getById(@PathVariable int userId);

}