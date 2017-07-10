package com.kowalczyk.workouter.controllers.security;

import com.kowalczyk.workouter.controllers.AbstractControllerTest;
import com.kowalczyk.workouter.enums.RoleType;
import com.kowalczyk.workouter.model.DTO.security.RoleDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Created by JK on 2017-04-08.
 */
public class RoleControllerTest extends AbstractControllerTest {

    @Autowired
    private RoleController roleController;

    @Test
    public void getObject() throws Exception {
        RoleDTO roleDTO = roleController.addObject(buildRoleDTOTest());
        RoleDTO expectedRoleDTO = roleController.getObject(roleDTO.getId());
        assertEquals(roleDTO.getId(), expectedRoleDTO.getId());
        assertEquals(roleDTO.getRoleType(), expectedRoleDTO.getRoleType());
        deleteRoles(expectedRoleDTO);
    }

    public void deleteRoles(RoleDTO roleDTO) {
        roleController.deleteObject(roleDTO.getId());
        assertFalse(roleController.isExist(roleDTO.getId()));
    }

    @Test
    public void updateObject() throws Exception {
        RoleDTO roleDTO = roleController.addObject(buildRoleDTOTest());
        roleDTO.setRoleType(RoleType.TRAINER);
        roleDTO = roleController.updateObject(roleDTO);
        assertEquals(RoleType.TRAINER, roleDTO.getRoleType());
        deleteRoles(roleDTO);
    }

    @Test
    public void findAll() throws Exception {
        List<RoleDTO> roleDTOS = roleController.findAll();
        assertEquals(1, roleDTOS.size());
        RoleDTO roleDTO = buildRoleDTOTest();
        roleDTO.setRoleType(RoleType.USER);
        roleDTO = roleController.addObject(roleDTO);
        Long roleDTOId = roleDTO.getId();
        roleDTOS = roleController.findAll();
        assertEquals(2, roleDTOS.size());
        assertTrue(roleDTOS.stream().anyMatch(r -> Objects.equals(r.getId(), roleDTOId)));

        RoleDTO roleDTO1 = buildRoleDTOTest();
        roleDTO1.setRoleType(RoleType.TRAINER);
        roleDTO1 = roleController.addObject(roleDTO1);
        roleDTOS = roleController.findAll();
        assertEquals(3, roleDTOS.size());

        deleteRoles(roleDTO);
        roleDTOS = roleController.findAll();
        assertEquals(2, roleDTOS.size());
        deleteRoles(roleDTO1);
        roleDTOS = roleController.findAll();
        assertEquals(1, roleDTOS.size());
    }

}