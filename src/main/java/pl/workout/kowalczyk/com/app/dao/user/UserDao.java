package pl.workout.kowalczyk.com.app.dao.user;

import pl.workout.kowalczyk.com.app.dao.BaseDao;
import pl.workout.kowalczyk.com.app.model.BO.user.User;

/**
 * Created by JK on 2016-09-07.
 */
public interface UserDao extends BaseDao<User> {
    User getByLogin(String login);
}
