package com.kowalczyk.workouter.model.DTO.security;

import com.kowalczyk.workouter.enums.RoleType;
import com.kowalczyk.workouter.model.DTO.ObjectDTO;

/**
 * Created by JK on 2017-04-04.
 */
public class RoleDTO extends ObjectDTO {

    private RoleType roleType;

    public RoleDTO() {
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType name) {
        this.roleType = name;
    }
}
