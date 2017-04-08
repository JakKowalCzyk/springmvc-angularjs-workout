package com.kowalczyk.workouter.controllers.user;

/**
 * Created by JK on 2017-01-22.
 */

import com.kowalczyk.workouter.controllers.ModelController;
import com.kowalczyk.workouter.model.DTO.user.impl.UserInfoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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