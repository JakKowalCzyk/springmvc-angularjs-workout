package com.kowalczyk.workouter.configuration.security.social;

import com.kowalczyk.workouter.model.BO.user.User;
import com.kowalczyk.workouter.services.user.UserService;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.facebook.api.Facebook;

/**
 * Created by JKowalczyk on 2017-08-09.
 */
public class FacebookConnectionSignUp implements ConnectionSignUp{

    private UserService userService;

    public FacebookConnectionSignUp(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(Connection<?> connection) {

        Facebook facebook = (Facebook) connection.getApi();
        org.springframework.social.facebook.api.User userProfile = facebook.fetchObject("me", org.springframework.social.facebook.api.User.class, "id", "email", "first_name", "last_name");
        User user = userService.createSocialAccount(userProfile);
        return user.getLogin();
    }
}
