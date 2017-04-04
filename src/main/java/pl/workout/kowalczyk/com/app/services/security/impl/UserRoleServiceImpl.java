package pl.workout.kowalczyk.com.app.services.security.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.workout.kowalczyk.com.app.dao.security.UserRoleDao;
import pl.workout.kowalczyk.com.app.model.BO.security.UserRole;
import pl.workout.kowalczyk.com.app.services.impl.ModelServiceImpl;
import pl.workout.kowalczyk.com.app.services.security.UserRoleService;

/**
 * Created by JK on 2017-04-04.
 */
@Service
public class UserRoleServiceImpl extends ModelServiceImpl<UserRole> implements UserRoleService {

    @Autowired
    public UserRoleServiceImpl(UserRoleDao baseDao) {
        super(baseDao);
    }
}
