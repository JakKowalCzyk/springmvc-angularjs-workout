package com.kowalczyk.workouter.controllers.security;

import com.kowalczyk.workouter.controllers.AbstractControllerTest;
import com.kowalczyk.workouter.enums.RoleType;
import com.kowalczyk.workouter.model.DTO.security.RoleDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by JK on 2017-04-08.
 */
public class RoleControllerTest extends AbstractControllerTest {

    @Autowired
    private RoleController roleController;

    @Test
    public void getObject() throws Exception {
        RoleDTO roleDTO = buildRoleDTOTest();
        roleDTO = roleController.addObject(roleDTO);
        assertTrue(1L == roleDTO.getId());
        assertEquals(RoleType.ADMIN, roleDTO.getRoleType());
        roleDTO.setRoleType(RoleType.USER);
        roleDTO = roleController.addObject(roleDTO);
        assertTrue(2L == roleDTO.getId());
        assertTrue(1L == roleController.getObject(1L).getId());
        assertEquals(RoleType.ADMIN, roleController.getObject(1L).getRoleType());
        assertEquals(RoleType.USER, roleController.getObject(2L).getRoleType());
        roleDTO.setRoleType(RoleType.TRAINER);
        roleController.updateObject(roleDTO);
        assertEquals(RoleType.TRAINER, roleController.getObject(2L).getRoleType());
    }

    @Test
    public void updateObject() throws Exception {

    }

    @Test
    public void addObject() throws Exception {

    }

    @Test
    public void findAll() throws Exception {

    }

    @Test
    public void deleteObject() throws Exception {

    }

}