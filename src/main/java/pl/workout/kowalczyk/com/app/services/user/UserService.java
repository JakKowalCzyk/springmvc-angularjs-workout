package pl.workout.kowalczyk.com.app.services.user;

import pl.workout.kowalczyk.com.app.model.BO.user.User;
import pl.workout.kowalczyk.com.app.services.ModelService;

/**
 * Created by JK on 2016-10-26.
 */
public interface UserService extends ModelService<User> {

    User getUserByLogin(String login);

}
