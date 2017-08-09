package com.kowalczyk.workouter.configuration.security.social;

import com.kowalczyk.workouter.enums.RoleType;
import com.kowalczyk.workouter.model.BO.security.Role;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Arrays;

/**
 * Created by JKowalczyk on 2017-08-09.
 */
public class FacebookSignInAdapter implements SignInAdapter {
    @Override
    public String signIn(String s, Connection<?> connection, NativeWebRequest nativeWebRequest) {
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(connection.fetchUserProfile().getEmail(), null,
                Arrays.asList(new SimpleGrantedAuthority(RoleType.USER.name()))));
        return null;
    }
}
