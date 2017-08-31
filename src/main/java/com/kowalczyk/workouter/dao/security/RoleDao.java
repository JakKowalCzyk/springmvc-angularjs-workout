package com.kowalczyk.workouter.dao.security;

import com.kowalczyk.workouter.dao.BaseDao;
import com.kowalczyk.workouter.enums.RoleType;
import com.kowalczyk.workouter.model.BO.security.Role;

/**
 * Created by JK on 2016-12-18.
 */
public interface RoleDao extends BaseDao<Role> {

    Role findByRoleType(RoleType roleType);
}
