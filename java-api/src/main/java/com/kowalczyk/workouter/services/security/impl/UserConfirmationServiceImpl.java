package com.kowalczyk.workouter.services.security.impl;

import com.kowalczyk.workouter.dao.security.UserConfirmationTokenDAO;
import com.kowalczyk.workouter.model.BO.security.UserConfirmationToken;
import com.kowalczyk.workouter.model.BO.user.User;
import com.kowalczyk.workouter.services.impl.ModelServiceImpl;
import com.kowalczyk.workouter.services.notification.email.account.AccountConfirmationEmailService;
import com.kowalczyk.workouter.services.security.DecryptionService;
import com.kowalczyk.workouter.services.security.UserConfirmationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by JK on 2017-09-16.
 */
@Service
public class UserConfirmationServiceImpl extends ModelServiceImpl<UserConfirmationToken> implements UserConfirmationService {

    public static final String TOKEN = "token=";
    private AccountConfirmationEmailService accountConfirmationEmailService;
    private DecryptionService decryptionService;

    @Autowired
    public UserConfirmationServiceImpl(UserConfirmationTokenDAO baseDAO, AccountConfirmationEmailService accountConfirmationEmailService, DecryptionService decryptionService) {
        super(baseDAO);
        this.accountConfirmationEmailService = accountConfirmationEmailService;
        this.decryptionService = decryptionService;
    }

    @Override
    public void startConfirmationProcess(User user, String uri) {
        UserConfirmationToken userConfirmationToken = getUserConfirmationToken(user);
        String preparedUrl = prepareUri(userConfirmationToken, uri);
        sendEmailToUserWithConfirmationLink(userConfirmationToken, preparedUrl);
    }

    @Override
    public void deleteByUser(User user) {
        Optional<UserConfirmationToken> tokenOptional = Optional.ofNullable(findByUser(user));
        tokenOptional.ifPresent(userConfirmationToken -> super.deleteObject(findByUser(user)));
    }

    @Override
    public UserConfirmationToken findByUser(User user) {
        return ((UserConfirmationTokenDAO) getBaseDAO()).findByUser(user);
    }

    @Override
    public Optional<UserConfirmationToken> findByToken(String token) {
        return Optional.ofNullable(((UserConfirmationTokenDAO) getBaseDAO()).findByToken(token));
    }


    public UserConfirmationToken getUserConfirmationToken(User user) {
        UserConfirmationToken userConfirmationToken = new UserConfirmationToken();
        userConfirmationToken.setUser(user);
        userConfirmationToken.setToken(UUID.randomUUID().toString());
        addObject(userConfirmationToken);
        return userConfirmationToken;
    }

    private void sendEmailToUserWithConfirmationLink(UserConfirmationToken userConfirmationToken, String uri) {
        accountConfirmationEmailService.sendEmailToUserWithConfirmationLink(userConfirmationToken, uri);
    }

    @Override
    public UserConfirmationToken addObject(UserConfirmationToken baseModel) {
        return super.addObject(baseModel);
    }


    public String prepareUri(UserConfirmationToken userConfirmationToken, String uri) {
        uri = uri.replace(TOKEN, String.format("token=%s", userConfirmationToken.getToken()));
        return uri;
    }

}
