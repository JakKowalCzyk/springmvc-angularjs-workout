package com.kowalczyk.workouter.services.security.impl;

import com.kowalczyk.workouter.dao.security.UserConfirmationTokenDAO;
import com.kowalczyk.workouter.model.BO.security.UserConfirmationToken;
import com.kowalczyk.workouter.model.BO.user.User;
import com.kowalczyk.workouter.services.impl.ModelServiceImpl;
import com.kowalczyk.workouter.services.security.UserConfirmationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by JK on 2017-09-16.
 */
@Service
public class UserConfirmationServiceImpl extends ModelServiceImpl<UserConfirmationToken> implements UserConfirmationService {

    @Autowired
    public UserConfirmationServiceImpl(UserConfirmationTokenDAO baseDAO) {
        super(baseDAO);
    }

    @Override
    public void startConfirmationProcess(User user, String uri) {
        UserConfirmationToken userConfirmationToken = new UserConfirmationToken();
        userConfirmationToken.setUser(user);
        userConfirmationToken.setToken(UUID.randomUUID().toString());
        sendEmailToUserWithConfirmationLink(userConfirmationToken, uri);
    }

    private void sendEmailToUserWithConfirmationLink(UserConfirmationToken userConfirmationToken, String uri) {

    }

    @Override
    public UserConfirmationToken addObject(UserConfirmationToken baseModel) {
        return super.addObject(baseModel);
    }
}
