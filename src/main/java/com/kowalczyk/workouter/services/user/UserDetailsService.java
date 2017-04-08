package com.kowalczyk.workouter.services.user;

import com.kowalczyk.workouter.model.BO.user.UserDetails;
import com.kowalczyk.workouter.services.ModelService;

/**
 * Created by JK on 2016-12-18.
 */
public interface UserDetailsService extends org.springframework.security.core.userdetails.UserDetailsService, ModelService<UserDetails> {

    UserDetails getByLogin(String login);
}
