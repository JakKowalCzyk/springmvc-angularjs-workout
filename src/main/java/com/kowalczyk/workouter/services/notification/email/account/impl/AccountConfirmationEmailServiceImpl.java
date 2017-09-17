package com.kowalczyk.workouter.services.notification.email.account.impl;

import com.kowalczyk.workouter.model.BO.security.UserConfirmationToken;
import com.kowalczyk.workouter.services.notification.email.EmailSenderService;
import com.kowalczyk.workouter.services.notification.email.account.AccountConfirmationEmailService;
import com.kowalczyk.workouter.services.notification.email.impl.GenericEmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by JK on 2017-09-16.
 */
@Service
public class AccountConfirmationEmailServiceImpl extends GenericEmailServiceImpl implements AccountConfirmationEmailService {

    @Autowired
    public AccountConfirmationEmailServiceImpl(EmailSenderService emailSenderService) {
        super(emailSenderService);
    }

    @Override
    public void sendEmailToUserWithConfirmationLink(UserConfirmationToken userConfirmationToken, String uri) {

    }

}
