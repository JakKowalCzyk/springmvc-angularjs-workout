package com.kowalczyk.workouter.controllers.user;

import com.kowalczyk.workouter.controllers.ModelController;
import com.kowalczyk.workouter.model.DTO.user.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * Created by JK on 2017-04-08.
 */
@Api(tags = "User Details API", description = "Services for User")
@RequestMapping("/api/user")
public interface UserController extends ModelController<UserDTO> {

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    UserDTO getObject(@PathVariable Long id);

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    UserDTO updateObject(@RequestBody UserDTO model);

    @Override
    @RequestMapping(method = RequestMethod.POST)
    UserDTO addObject(@RequestBody UserDTO model);

    @Override
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<UserDTO> findAll();

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void deleteObject(@PathVariable Long id);

    @Override
    @RequestMapping(value = "/exist", method = RequestMethod.GET)
    boolean isExist(@PathVariable Long id);

    @ApiOperation(value = "Get principal")
    @RequestMapping(value = "/principal", method = RequestMethod.GET)
    UserDTO getPrincipal(Principal principal);

    @ApiOperation(value = "Get user by login")
    @RequestMapping(value = "/login}", method = RequestMethod.GET)
    UserDTO getByLogin(@PathVariable String login);

    @ApiOperation(value = "Start confirmation account procedure")
    @RequestMapping(value = "/{id}/confirm/", method = RequestMethod.POST)
    void startConfirmationProcedure(@RequestParam String uri, @PathVariable Long id);

    @ApiOperation(value = "Confirm user's account")
    @RequestMapping(value = "/{id}/token/{token}", method = RequestMethod.PUT)
    boolean confirmAccount(@PathVariable Long id, @PathVariable String token);
}
