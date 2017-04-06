package pl.workout.kowalczyk.com.app.mapper.security;

import org.springframework.stereotype.Component;
import pl.workout.kowalczyk.com.app.mapper.impl.ModelMapperImpl;
import pl.workout.kowalczyk.com.app.model.BO.security.Role;
import pl.workout.kowalczyk.com.app.model.DTO.security.RoleDTO;

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
