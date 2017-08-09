package com.kowalczyk.workouter.configuration.security.social;

import com.kowalczyk.workouter.model.BO.user.UserDetails;
import com.kowalczyk.workouter.services.user.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by JKowalczyk on 2017-08-09.
 */
@Service
public class FacebookConnectionSignUp implements ConnectionSignUp{

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public String execute(Connection<?> connection) {
        FacebookTemplate facebookTemplate = (FacebookTemplate) connection.getApi();
        User userProfile =  facebookTemplate.userOperations().getUserProfile();
        UserDetails userDetails = new UserDetails();
        userDetails.setFirstName(userProfile.getFirstName());
        userDetails.setLastName(userProfile.getLastName());

        //TODO new random hashed password
        userDetails.setHashedPassword("pass");
        userDetails.setAccountNonExpired(true);
        userDetails.setAccountNonLocked(true);
        userDetails.setCredentialsNonExpired(true);
        userDetails.setEmail(userProfile.getEmail());
        userDetailsService.addObject(userDetails);
        return userDetails.getEmail();
    }
}
