package com.kowalczyk.workouter.controllers.security.impl;

import com.kowalczyk.workouter.controllers.impl.ModelControllerImpl;
import com.kowalczyk.workouter.controllers.security.RoleController;
import com.kowalczyk.workouter.mapper.security.RoleMapper;
import com.kowalczyk.workouter.model.BO.security.Role;
import com.kowalczyk.workouter.model.DTO.security.RoleDTO;
import com.kowalczyk.workouter.services.security.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by JK on 2017-04-08.
 */
@RestController
public class RoleControllerImpl extends ModelControllerImpl<Role, RoleDTO> implements RoleController {

    @Autowired
    public RoleControllerImpl(RoleService modelService, RoleMapper modelMapper) {
        super(modelService, modelMapper);
    }

    @Override
    public RoleDTO getObject(@PathVariable Long id) {
        return super.getObject(id);
    }

    @Override
    public RoleDTO updateObject(@RequestBody RoleDTO model) {
        return super.updateObject(model);
    }

    @Override
    public RoleDTO addObject(@RequestBody RoleDTO model) {
        return super.addObject(model);
    }

    @Override
    public List<RoleDTO> findAll() {
        return super.findAll();
    }

    @Override
    public boolean isExist(@PathVariable Long id) {
        return super.isExist(id);
    }

    @Override
    public void deleteObject(@PathVariable Long id) {
        super.deleteObject(id);
    }
}
