package pl.workout.kowalczyk.com.app.dao.security;

import pl.workout.kowalczyk.com.app.dao.BaseDao;
import pl.workout.kowalczyk.com.app.model.BO.security.UserDetails;

/**
 * Created by JK on 2016-12-12.
 */
public interface UserDetailsDao extends BaseDao<UserDetails> {

    UserDetails getByLogin(String login);

}
