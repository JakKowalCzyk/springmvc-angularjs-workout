package com.kowalczyk.workouter.services.security;

import com.kowalczyk.workouter.enums.RoleType;
import com.kowalczyk.workouter.model.BO.security.Role;
import com.kowalczyk.workouter.services.ModelService;

/**
 * Created by JK on 2017-04-04.
 */
public interface RoleService extends ModelService<Role> {

    Role findByRoleType(RoleType roleType);
}
