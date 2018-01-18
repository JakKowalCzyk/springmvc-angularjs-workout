package com.kowalczyk.workouter.services.security.token.impl;

import com.kowalczyk.workouter.dao.security.token.GenericTokenDAO;
import com.kowalczyk.workouter.model.BO.security.token.GenericToken;
import com.kowalczyk.workouter.model.BO.user.User;
import com.kowalczyk.workouter.services.impl.ModelServiceImpl;
import com.kowalczyk.workouter.services.security.token.GenericTokenService;

import java.util.Optional;

/**
 * Created by JK on 2018-01-14.
 */
public abstract class GenericTokenServiceImpl<T extends GenericToken> extends ModelServiceImpl<T> implements GenericTokenService<T> {

    public static final String TOKEN = "token=";

    public GenericTokenServiceImpl(GenericTokenDAO<T> baseDAO) {
        super(baseDAO);
    }

    @Override
    public void startTokenProcedure(User user, String uri) {
        T token = getNewToken(user);
        sendMessageWithToken(token, prepareUri(token, uri));
    }

    @Override
    public void deleteByUser(User user) {
        Optional<T> tokenOptional = Optional.ofNullable(findByUser(user));
        tokenOptional.ifPresent(super::deleteObject);
    }

    @Override
    public T findByUser(User user) {
        return getBaseDAO().findByUser(user);
    }

    @Override
    public Optional<T> findByToken(String token) {
        return Optional.ofNullable(getBaseDAO().findByToken(token));
    }


    @Override
    public String prepareUri(T token, String uri) {
        uri = uri.replace(TOKEN, String.format("token=%s", token.getToken()));
        return uri;
    }

    @Override
    protected GenericTokenDAO<T> getBaseDAO() {
        return (GenericTokenDAO<T>) super.getBaseDAO();
    }
}
