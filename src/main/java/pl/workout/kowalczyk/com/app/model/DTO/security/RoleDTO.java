package pl.workout.kowalczyk.com.app.model.DTO.security;

import pl.workout.kowalczyk.com.app.enums.RoleType;
import pl.workout.kowalczyk.com.app.model.DTO.ObjectDTO;

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
