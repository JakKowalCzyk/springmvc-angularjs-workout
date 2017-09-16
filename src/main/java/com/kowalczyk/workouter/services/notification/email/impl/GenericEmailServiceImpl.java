package com.kowalczyk.workouter.services.notification.email.impl;

import com.kowalczyk.workouter.services.notification.email.EmailSenderService;
import com.kowalczyk.workouter.services.notification.email.GenericEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by JK on 2017-09-16.
 */
@Service
public abstract class GenericEmailServiceImpl implements GenericEmailService {

    private EmailSenderService emailSenderService;

    @Autowired
    public GenericEmailServiceImpl(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    public EmailSenderService getEmailSenderService() {
        return emailSenderService;
    }
}
