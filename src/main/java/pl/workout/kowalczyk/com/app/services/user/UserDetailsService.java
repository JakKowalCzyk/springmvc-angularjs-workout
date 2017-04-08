package pl.workout.kowalczyk.com.app.services.user;

import pl.workout.kowalczyk.com.app.model.BO.user.UserDetails;
import pl.workout.kowalczyk.com.app.services.ModelService;

/**
 * Created by JK on 2016-12-18.
 */
public interface UserDetailsService extends org.springframework.security.core.userdetails.UserDetailsService, ModelService<UserDetails> {

    UserDetails getByLogin(String login);
}
