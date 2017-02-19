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
import pl.workout.kowalczyk.com.app.controllers.ModelController;
import pl.workout.kowalczyk.com.app.model.DTO.user.UserInfoDTO;

import java.util.List;

@Api(tags = {"User Info API"}, description = "Services for user info")
@RequestMapping("/user/info")
public interface UserInfoController extends ModelController<UserInfoDTO> {

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    UserInfoDTO getObject(@PathVariable Long id);

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    UserInfoDTO updateObject(@RequestBody UserInfoDTO model);

    @Override
    @RequestMapping(method = RequestMethod.POST)
    UserInfoDTO addObject(@RequestBody UserInfoDTO model);

    @Override
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<UserInfoDTO> findAll();

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void deleteObject(@PathVariable Long id);

    @ApiOperation(value = "Get User info for user")
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    UserInfoDTO getById(@PathVariable Long id);

}