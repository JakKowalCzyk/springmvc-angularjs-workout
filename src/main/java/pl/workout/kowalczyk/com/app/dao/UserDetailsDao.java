package pl.workout.kowalczyk.com.app.dao;

import pl.workout.kowalczyk.com.app.model.BO.UserDetails;

/**
 * Created by JK on 2016-12-12.
 */
public interface UserDetailsDao extends BaseDao<UserDetails>{

    UserDetails getByLogin(String login);

}
