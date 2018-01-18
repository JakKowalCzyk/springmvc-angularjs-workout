package com.kowalczyk.workouter.services.notification.email.password.impl;

import com.kowalczyk.workouter.model.BO.security.token.ResetPasswordToken;
import com.kowalczyk.workouter.model.BO.user.User;
import com.kowalczyk.workouter.model.exception.ResetPasswordException;
import com.kowalczyk.workouter.services.notification.email.EmailSenderService;
import com.kowalczyk.workouter.services.notification.email.impl.GenericEmailServiceImpl;
import com.kowalczyk.workouter.services.notification.email.password.ResetPasswordEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

/**
 * Created by JK on 2018-01-15.
 */
@Service
public class ResetPasswordEmailServiceImpl extends GenericEmailServiceImpl implements ResetPasswordEmailService {

    public static final String SUBJECT = "Reset Your password";

    @Autowired
    public ResetPasswordEmailServiceImpl(EmailSenderService emailSenderService, JavaMailSender javaMailSender) {
        super(emailSenderService, javaMailSender);
    }

    @Override
    public void sendResetPasswordEmail(ResetPasswordToken resetPasswordToken, String body) {
        try {
            super.sendMessage(prepareMessage(getEmailTo(resetPasswordToken.getUser()), getBody(body), getSubject()));
        } catch (MessagingException e) {
            throw new ResetPasswordException();
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
