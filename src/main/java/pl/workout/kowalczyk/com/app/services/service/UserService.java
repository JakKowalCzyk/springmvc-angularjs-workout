package pl.workout.kowalczyk.com.app.services.service;

import pl.workout.kowalczyk.com.app.model.data.model.entity.User;

/**
 * Created by JK on 2016-10-26.
 */
public interface UserService {
    User getUserByLogin(String login);

    void saveUser(User user);

    void updateUser(User user);
}
