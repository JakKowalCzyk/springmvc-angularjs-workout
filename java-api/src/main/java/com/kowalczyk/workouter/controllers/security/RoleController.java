package com.kowalczyk.workouter.controllers.security;

import com.kowalczyk.workouter.controllers.ModelController;
import com.kowalczyk.workouter.enums.RoleType;
import com.kowalczyk.workouter.model.DTO.security.RoleDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by JK on 2017-04-08.
 */
@Api(tags = "Role API", description = "Services for Roles")
@RequestMapping("/api/role")
public interface RoleController extends ModelController<RoleDTO> {

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    RoleDTO getObject(@PathVariable Long id);

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    RoleDTO updateObject(@RequestBody RoleDTO model);

    @Override
    @RequestMapping(method = RequestMethod.POST)
    RoleDTO addObject(@RequestBody RoleDTO model);

    @Override
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<RoleDTO> findAll();

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void deleteObject(@PathVariable Long id);

    @ApiOperation(value = "Find role by role type")
    @RequestMapping(value = "/type", method = RequestMethod.GET)
    RoleDTO findByRoleType(@RequestParam RoleType roleType);

    @Override
    @RequestMapping(value = "/exist", method = RequestMethod.GET)
    boolean isExist(@PathVariable Long id);
}
