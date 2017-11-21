package com.kowalczyk.workouter.mapper.security;

import com.kowalczyk.workouter.enums.RoleType;
import com.kowalczyk.workouter.mapper.AbstractMapperTest;
import com.kowalczyk.workouter.model.BO.security.Role;
import com.kowalczyk.workouter.model.DTO.security.RoleDTO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/**
 * Created by JK on 2017-04-06.
 */
public class RoleMapperTest extends AbstractMapperTest {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void mapToBO() throws Exception {
        RoleDTO roleDTO = getRoleDTOTest(RoleType.ADMIN);
        Role role = roleMapper.mapToBO(roleDTO);
        Assert.assertEquals(roleDTO.getId(), role.getId());
        assertEquals(RoleType.ADMIN, role.getRoleType());
    }

    @Test
    public void mapToDTO() throws Exception {
        Role role = getUserRoleTest();
        RoleDTO roleDTO = roleMapper.mapToDTO(role);
        Assert.assertEquals(role.getId(), roleDTO.getId());
        Assert.assertEquals(RoleType.USER, roleDTO.getRoleType());
    }

}