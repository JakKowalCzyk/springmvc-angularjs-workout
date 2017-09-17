package com.kowalczyk.workouter.services.security.impl;

import com.kowalczyk.workouter.dao.security.UserConfirmationTokenDAO;
import com.kowalczyk.workouter.model.BO.security.UserConfirmationToken;
import com.kowalczyk.workouter.model.BO.user.User;
import com.kowalczyk.workouter.model.exception.ConfirmationAccountException;
import com.kowalczyk.workouter.services.impl.ModelServiceImpl;
import com.kowalczyk.workouter.services.notification.email.account.AccountConfirmationEmailService;
import com.kowalczyk.workouter.services.security.UserConfirmationService;
import com.kowalczyk.workouter.services.security.helper.DecryptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.UUID;

/**
 * Created by JK on 2017-09-16.
 */
@Service
public class UserConfirmationServiceImpl extends ModelServiceImpl<UserConfirmationToken> implements UserConfirmationService {

    private AccountConfirmationEmailService accountConfirmationEmailService;

    @Autowired
    public UserConfirmationServiceImpl(UserConfirmationTokenDAO baseDAO, AccountConfirmationEmailService accountConfirmationEmailService) {
        super(baseDAO);
        this.accountConfirmationEmailService = accountConfirmationEmailService;
    }

    @Override
    public void startConfirmationProcess(User user, String uri) {
        UserConfirmationToken userConfirmationToken = new UserConfirmationToken();
        userConfirmationToken.setUser(user);
        userConfirmationToken.setToken(UUID.randomUUID().toString());
        String preparedUrl = prepareUri(userConfirmationToken, uri);
        sendEmailToUserWithConfirmationLink(userConfirmationToken, preparedUrl);
    }

    private void sendEmailToUserWithConfirmationLink(UserConfirmationToken userConfirmationToken, String uri) {
        accountConfirmationEmailService.sendEmailToUserWithConfirmationLink(userConfirmationToken, uri);
    }

    @Override
    public UserConfirmationToken addObject(UserConfirmationToken baseModel) {
        return super.addObject(baseModel);
    }


    private String prepareUri(UserConfirmationToken userConfirmationToken, String uri) {
        String encryptedToken = null;
        try {
            encryptedToken = encryptToken(userConfirmationToken);
        } catch (GeneralSecurityException | IOException e) {
            throw new ConfirmationAccountException(userConfirmationToken.getUser().getId());
        }
        return String.format("%s/%s/%s", uri, userConfirmationToken.getUser().getId(), encryptedToken);
    }

    private String encryptToken(UserConfirmationToken userConfirmationToken) throws GeneralSecurityException, IOException {
        return new DecryptionHelper()
                .encryptWithPublicKey(userConfirmationToken.getToken(), "C:/ssh/workouter_priv.jks", "workouter-api", "workouter");
    }
}
