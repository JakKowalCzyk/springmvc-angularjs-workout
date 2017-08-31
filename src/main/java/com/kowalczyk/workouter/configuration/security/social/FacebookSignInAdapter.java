package com.kowalczyk.workouter.configuration.security.social;

import com.kowalczyk.workouter.enums.RoleType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

/**
 * Created by JKowalczyk on 2017-08-09.
 */
@Component
public class FacebookSignInAdapter implements SignInAdapter {


    @Override
    public String signIn(String s, Connection<?> connection, NativeWebRequest nativeWebRequest) {
        Facebook facebook = (Facebook) connection.getApi();
        User userProfile = facebook.fetchObject("me", User.class, "id", "email", "first_name", "last_name");
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userProfile.getId(), null,
                Arrays.asList(new SimpleGrantedAuthority(RoleType.USER.name())));
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        attr.getRequest().getSession().setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());

        return null;
    }
}
