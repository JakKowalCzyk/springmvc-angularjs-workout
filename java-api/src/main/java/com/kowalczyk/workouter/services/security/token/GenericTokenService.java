package com.kowalczyk.workouter.services.security.token;

import com.kowalczyk.workouter.model.BO.security.token.GenericToken;
import com.kowalczyk.workouter.model.BO.user.User;
import com.kowalczyk.workouter.services.ModelService;

import java.util.Optional;

/**
 * Created by JK on 2018-01-14.
 */
public interface GenericTokenService<T extends GenericToken> extends ModelService<T> {

    void startTokenProcedure(User user, String uri);

    void deleteByUser(User user);

    T findByUser(User user);

    Optional<T> findByToken(String token);

    T getNewToken(User user);

    String prepareUri(T token, String uri);

    void sendMessageWithToken(T token, String preparedUri);
}
