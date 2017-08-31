package com.kowalczyk.workouter.configuration.security.social;

import com.kowalczyk.workouter.enums.RoleType;
import com.kowalczyk.workouter.model.BO.user.UserDetails;
import com.kowalczyk.workouter.services.security.RoleService;
import com.kowalczyk.workouter.services.user.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by JKowalczyk on 2017-08-09.
 */
@Service
public class FacebookConnectionSignUp implements ConnectionSignUp{

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private RoleService roleService;

    @Override
    public String execute(Connection<?> connection) {

        Facebook facebook = (Facebook) connection.getApi();
        User userProfile = facebook.fetchObject("me", User.class, "id", "email", "first_name", "last_name");
        UserDetails userDetails = new UserDetails();
        userDetails.setFirstName(userProfile.getFirstName());
        userDetails.setLastName(userProfile.getLastName());

        Random random = new Random();
        userDetails.setHashedPassword(Long.toHexString(Double.doubleToLongBits(random.nextInt(8))));

        userDetails.setAccountNonExpired(true);
        userDetails.setAccountNonLocked(true);
        userDetails.setCredentialsNonExpired(true);
        userDetails.setEnabled(true);
        userDetails.setEmail(userProfile.getEmail());
        userDetails.setLogin(userProfile.getId());
        userDetails.getRoles().add(roleService.findByRoleType(RoleType.USER));
        userDetailsService.addObject(userDetails);
        return userDetails.getLogin();
    }
}
