package com.kowalczyk.workouter.services.security.impl;

import com.kowalczyk.workouter.enums.RoleType;
import com.kowalczyk.workouter.dao.security.RoleDAO;
import com.kowalczyk.workouter.model.BO.security.Role;
import com.kowalczyk.workouter.model.exception.DeleteException;
import com.kowalczyk.workouter.services.impl.ModelServiceImpl;
import com.kowalczyk.workouter.services.security.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by JK on 2017-04-04.
 */
@Service
public class RoleServiceImpl extends ModelServiceImpl<Role> implements RoleService {

    @Autowired
    public RoleServiceImpl(RoleDAO baseDao) {
        super(baseDao);
    }

    @Override
    public void deleteObject(Long id) {
        try {
            super.deleteObject(id);
        } catch (Exception e) {
            throw new DeleteException(id);
        }

    }

    @Override
    public Role findByRoleType(RoleType roleType) {
        return ((RoleDAO) getBaseDAO()).findByRoleType(roleType);
    }
}
