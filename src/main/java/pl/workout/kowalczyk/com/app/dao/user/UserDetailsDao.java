package pl.workout.kowalczyk.com.app.dao.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.workout.kowalczyk.com.app.dao.BaseDao;
import pl.workout.kowalczyk.com.app.model.BO.user.UserDetails;

/**
 * Created by JK on 2016-12-12.
 */
public interface UserDetailsDao extends BaseDao<UserDetails> {

    @Query("select u from UserDetails as u where u.login = :login")
    UserDetails getByLogin(@Param("login") String login);

}
