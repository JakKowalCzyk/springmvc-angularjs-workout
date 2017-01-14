package pl.workout.kowalczyk.com.app.dao.security;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.workout.kowalczyk.com.app.dao.BaseDao;
import pl.workout.kowalczyk.com.app.model.BO.security.UserRole;

import java.util.List;

/**
 * Created by JK on 2016-12-18.
 */
public interface UserRoleDao extends BaseDao<UserRole> {

    @Query("select role from UserRole role inner join role.userDetails as user where user.login = :login")
    List getUserRolesByLogin(@Param("login") String userLogin);
}
