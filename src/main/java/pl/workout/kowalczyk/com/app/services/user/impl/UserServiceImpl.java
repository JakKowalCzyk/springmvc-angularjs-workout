package pl.workout.kowalczyk.com.app.services.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.workout.kowalczyk.com.app.dao.user.UserDao;
import pl.workout.kowalczyk.com.app.model.BO.user.User;
import pl.workout.kowalczyk.com.app.services.impl.ModelServiceImpl;
import pl.workout.kowalczyk.com.app.services.user.UserService;

/**
 * Created by JK on 2016-10-26.
 */
@Service
public class UserServiceImpl extends ModelServiceImpl<User> implements UserService {

    @Autowired
    public UserServiceImpl(UserDao baseDao) {
        super(baseDao);
    }

    public User getUserByLogin(String login) {
        return ((UserDao) getBaseDao()).getByLogin(login);
    }

}
