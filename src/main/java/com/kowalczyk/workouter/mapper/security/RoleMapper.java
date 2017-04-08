package com.kowalczyk.workouter.mapper.security;

import com.kowalczyk.workouter.mapper.impl.ModelMapperImpl;
import com.kowalczyk.workouter.model.BO.security.Role;
import com.kowalczyk.workouter.model.DTO.security.RoleDTO;
import org.springframework.stereotype.Component;

/**
 * Created by JK on 2017-04-06.
 */
@Component
public class RoleMapper extends ModelMapperImpl<Role, RoleDTO> {

    @Override
    protected Role buildBO(RoleDTO objectDTO) {
        Role role = new Role();
        role.setRoleType(objectDTO.getRoleType());
        return role;
    }

    @Override
    protected RoleDTO buildDTO(Role modelObject) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleType(modelObject.getRoleType());
        return roleDTO;
    }
}
