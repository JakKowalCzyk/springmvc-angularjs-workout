package com.kowalczyk.workouter.services.security.token.impl;

import com.kowalczyk.workouter.dao.security.token.UserConfirmationTokenDAO;
import com.kowalczyk.workouter.model.BO.security.token.UserConfirmationToken;
import com.kowalczyk.workouter.model.BO.user.User;
import com.kowalczyk.workouter.services.notification.email.account.AccountConfirmationEmailService;
import com.kowalczyk.workouter.services.security.token.UserConfirmationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by JK on 2017-09-16.
 */
@Service
public class UserConfirmationServiceImpl extends GenericTokenServiceImpl<UserConfirmationToken> implements UserConfirmationService {

    private AccountConfirmationEmailService accountConfirmationEmailService;

    @Autowired
    public UserConfirmationServiceImpl(UserConfirmationTokenDAO baseDAO, AccountConfirmationEmailService accountConfirmationEmailService) {
        super(baseDAO);
        this.accountConfirmationEmailService = accountConfirmationEmailService;
    }

    @Override
    public UserConfirmationToken getNewToken(User user) {
        UserConfirmationToken userConfirmationToken = new UserConfirmationToken();
        userConfirmationToken.setUser(user);
        userConfirmationToken.setToken(UUID.randomUUID().toString());
        addObject(userConfirmationToken);
        return userConfirmationToken;
    }

    @Override
    public void sendMessageWithToken(UserConfirmationToken token, String preparedUri) {
        accountConfirmationEmailService.sendEmailToUserWithConfirmationLink(token, preparedUri);
    }

}
