package com.kowalczyk.workouter.services.notification.email.account.impl;

import com.kowalczyk.workouter.model.BO.security.UserConfirmationToken;
import com.kowalczyk.workouter.model.BO.user.User;
import com.kowalczyk.workouter.model.exception.ConfirmationAccountException;
import com.kowalczyk.workouter.services.notification.email.EmailSenderService;
import com.kowalczyk.workouter.services.notification.email.account.AccountConfirmationEmailService;
import com.kowalczyk.workouter.services.notification.email.impl.GenericEmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

/**
 * Created by JK on 2017-09-16.
 */
@Service
public class AccountConfirmationEmailServiceImpl extends GenericEmailServiceImpl implements AccountConfirmationEmailService {

    private static final String SUBJECT = "Confirm Your account - Workouter";
    private static final String BODY = "To join Workouter and confirm Your account click here: ";

    @Autowired
    public AccountConfirmationEmailServiceImpl(EmailSenderService emailSenderService, JavaMailSender javaMailSender) {
        super(emailSenderService, javaMailSender);
    }

    @Override
    public void sendEmailToUserWithConfirmationLink(UserConfirmationToken userConfirmationToken, String uri) {
        try {
            super.sendMessage(prepareMessage(getEmailTo(userConfirmationToken.getUser()), getBody(uri), getSubject()));
        } catch (MessagingException e) {
            throw new ConfirmationAccountException(userConfirmationToken.getUser().getId());
        }
    }

    @Override
    public String getEmailTo(User user) {
        return user.getEmail();
    }

    @Override
    public String getSubject() {
        return SUBJECT;
    }

    @Override
    public String getBody(String textToInclude) {
        return textToInclude;
    }

}
