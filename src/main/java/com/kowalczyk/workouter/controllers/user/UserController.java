package com.kowalczyk.workouter.controllers.user;

import com.kowalczyk.workouter.controllers.ModelController;
import com.kowalczyk.workouter.model.DTO.user.UserDTO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/principal", method = RequestMethod.GET)
    UserDTO getPrincipal(Principal principal);

    @RequestMapping(value = "/login}", method = RequestMethod.GET)
    UserDTO getByLogin(@PathVariable String login);
}
