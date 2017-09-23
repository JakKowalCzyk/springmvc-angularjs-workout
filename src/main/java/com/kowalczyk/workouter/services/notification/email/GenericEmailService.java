package com.kowalczyk.workouter.services.notification.email;

import com.kowalczyk.workouter.model.BO.user.User;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by JK on 2017-09-16.
 */
public interface GenericEmailService {

    MimeMessage prepareMessage(String email, String body, String subject) throws MessagingException;

    String getEmailTo(User user);

    String getSubject();

    String getBody(String textToInclude);

    void sendMessage(MimeMessage mimeMessage);
}
