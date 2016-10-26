package pl.workout.kowalczyk.com.app.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.workout.kowalczyk.com.app.model.data.model.dao.UserDao;
import pl.workout.kowalczyk.com.app.model.data.model.entity.User;
import pl.workout.kowalczyk.com.app.services.service.UserService;

/**
 * Created by JK on 2016-10-26.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User getUserByLogin(String login){
        return userDao.getByLogin(login);
    }

    public void saveUser(User user){
        userDao.save(user);
    }

    public void updateUser(User user){
        userDao.update(user);
    }
}
