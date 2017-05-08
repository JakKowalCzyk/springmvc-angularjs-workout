package com.kowalczyk.workouter.controllers.user;

import com.kowalczyk.workouter.controllers.ModelController;
import com.kowalczyk.workouter.model.DTO.user.impl.UserWeightDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

/**
 * Created by JK on 2017-01-22.
 */
@Api(tags = {"User's weight API"}, description = "Services for user's weight")
@RequestMapping("/user/weight")
public interface UserWeightController extends ModelController<UserWeightDTO> {

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    UserWeightDTO getObject(@PathVariable Long id);

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    UserWeightDTO updateObject(@RequestBody UserWeightDTO model);

    @Override
    @RequestMapping(method = RequestMethod.POST)
    UserWeightDTO addObject(@RequestBody UserWeightDTO model);

    @Override
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<UserWeightDTO> findAll();

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void deleteObject(@PathVariable Long id);

    @ApiOperation(value = "Get weight for user")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    List<UserWeightDTO> getWeightByUserId(@PathVariable Long id);

    @ApiOperation(value = "Get weight for user by date")
    @RequestMapping(value = "/user/{id}/date/{date}", method = RequestMethod.GET)
    UserWeightDTO getWeightByDate(@PathVariable Long id, @PathVariable Date date);

    @ApiOperation(value = "Get actual weight for user")
    @RequestMapping(value = "/actual/user/{id}", method = RequestMethod.GET)
    UserWeightDTO getActualWeight(@PathVariable Long id);

}
