package pl.workout.kowalczyk.com.app.mapper.security;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.workout.kowalczyk.com.app.enums.RoleType;
import pl.workout.kowalczyk.com.app.mapper.AbstractMapperTest;
import pl.workout.kowalczyk.com.app.model.BO.security.Role;
import pl.workout.kowalczyk.com.app.model.DTO.security.RoleDTO;

import static org.junit.Assert.assertEquals;
import static pl.workout.kowalczyk.com.app.enums.RoleType.USER;

/**
 * Created by JK on 2017-04-06.
 */
public class RoleMapperTest extends AbstractMapperTest {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void mapToBO() throws Exception {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleType(RoleType.ADMIN);
        roleDTO.setId(5L);
        Role role = roleMapper.mapToBO(roleDTO);
        assertEquals(roleDTO.getId(), role.getId());
        assertEquals(RoleType.ADMIN, role.getRoleType());
    }

    @Test
    public void mapToDTO() throws Exception {
        Role role = getUserRoleTest();
        RoleDTO roleDTO = roleMapper.mapToDTO(role);
        assertEquals(role.getId(), roleDTO.getId());
        assertEquals(USER, roleDTO.getRoleType());
    }

}