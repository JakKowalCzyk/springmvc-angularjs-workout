package com.kowalczyk.workouter.configuration.security.social;

import com.kowalczyk.workouter.enums.RoleType;
import com.kowalczyk.workouter.model.BO.user.User;
import com.kowalczyk.workouter.services.security.RoleService;
import com.kowalczyk.workouter.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by JKowalczyk on 2017-08-09.
 */
@Service
public class FacebookConnectionSignUp implements ConnectionSignUp{

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Override
    public String execute(Connection<?> connection) {

        Facebook facebook = (Facebook) connection.getApi();
        org.springframework.social.facebook.api.User userProfile = facebook.fetchObject("me", org.springframework.social.facebook.api.User.class, "id", "email", "first_name", "last_name");
        User user = new User();
        user.setFirstName(userProfile.getFirstName());
        user.setLastName(userProfile.getLastName());

        Random random = new Random();
        user.setHashedPassword(Long.toHexString(Double.doubleToLongBits(random.nextInt(8))));

        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setEmail(userProfile.getEmail());
        user.setLogin(userProfile.getId());
        user.getRoles().add(roleService.findByRoleType(RoleType.USER));
        userService.addObject(user);
        return user.getLogin();
    }
}
