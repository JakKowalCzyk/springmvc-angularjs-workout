package pl.workout.kowalczyk.com.app.dao.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.workout.kowalczyk.com.app.dao.BaseDao;
import pl.workout.kowalczyk.com.app.model.BO.user.User;

/**
 * Created by JK on 2016-09-07.
 */
public interface UserDao extends BaseDao<User> {

    @Query("SELECT o FROM pl.workout.kowalczyk.com.app.model.BO.user.User AS o inner join o.userDetails as userDetails where userDetails.login = :login")
    User getByLogin(@Param("login") String login);
}
