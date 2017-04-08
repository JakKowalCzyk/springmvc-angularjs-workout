package pl.workout.kowalczyk.com.app.controllers.security.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.workout.kowalczyk.com.app.controllers.impl.ModelControllerImpl;
import pl.workout.kowalczyk.com.app.controllers.security.RoleController;
import pl.workout.kowalczyk.com.app.mapper.security.RoleMapper;
import pl.workout.kowalczyk.com.app.model.BO.security.Role;
import pl.workout.kowalczyk.com.app.model.DTO.security.RoleDTO;
import pl.workout.kowalczyk.com.app.services.security.RoleService;

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
    public void deleteObject(@PathVariable Long id) {
        super.deleteObject(id);
    }
}
