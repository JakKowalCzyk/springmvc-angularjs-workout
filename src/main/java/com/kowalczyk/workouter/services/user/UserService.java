package com.kowalczyk.workouter.services.user;

import com.kowalczyk.workouter.model.BO.user.User;
import com.kowalczyk.workouter.services.ModelService;

/**
 * Created by JK on 2016-12-18.
 */
public interface UserService extends org.springframework.security.core.userdetails.UserDetailsService, ModelService<User> {

    User getByLogin(String login);
}
