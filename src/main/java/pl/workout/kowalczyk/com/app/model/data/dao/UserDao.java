package pl.workout.kowalczyk.com.app.model.data.dao;

import pl.workout.kowalczyk.com.app.model.data.entity.User;

/**
 * Created by JK on 2016-09-07.
 */
public interface UserDao extends BaseDao<User> {
    User getByLogin(String login);
}
