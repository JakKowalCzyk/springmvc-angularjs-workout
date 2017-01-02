package pl.workout.kowalczyk.com.app.dao.security.impl;

import org.springframework.stereotype.Repository;
import pl.workout.kowalczyk.com.app.dao.impl.BaseDaoImpl;
import pl.workout.kowalczyk.com.app.dao.security.RoleDao;
import pl.workout.kowalczyk.com.app.model.BO.security.Role;

/**
 * Created by JK on 2016-12-18.
 */
@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {
}
