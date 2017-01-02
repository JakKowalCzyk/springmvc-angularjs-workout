package pl.workout.kowalczyk.com.app.dao;

import pl.workout.kowalczyk.com.app.model.BO.UserRole;

import java.util.List;

/**
 * Created by JK on 2016-12-18.
 */
public interface UserRoleDao extends BaseDao<UserRole> {

    List getUserRolesByLogin(String userLogin);
}
