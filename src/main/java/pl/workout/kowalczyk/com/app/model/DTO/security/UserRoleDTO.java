package pl.workout.kowalczyk.com.app.model.DTO.security;

import pl.workout.kowalczyk.com.app.model.DTO.ObjectDTO;

/**
 * Created by JK on 2017-04-04.
 */
public class UserRoleDTO extends ObjectDTO {
    private Long userDetailsId;
    private Long roleId;

    public UserRoleDTO() {
    }

    public Long getUserDetailsId() {
        return userDetailsId;
    }

    public void setUserDetailsId(Long userDetailsId) {
        this.userDetailsId = userDetailsId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
