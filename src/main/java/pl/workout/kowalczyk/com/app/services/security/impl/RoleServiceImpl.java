package pl.workout.kowalczyk.com.app.services.security.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.workout.kowalczyk.com.app.dao.security.RoleDao;
import pl.workout.kowalczyk.com.app.model.BO.security.Role;
import pl.workout.kowalczyk.com.app.services.impl.ModelServiceImpl;
import pl.workout.kowalczyk.com.app.services.security.RoleService;

/**
 * Created by JK on 2017-04-04.
 */
@Service
public class RoleServiceImpl extends ModelServiceImpl<Role> implements RoleService {

    @Autowired
    public RoleServiceImpl(RoleDao baseDao) {
        super(baseDao);
    }
}
