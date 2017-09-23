package com.kowalczyk.workouter.services.notification.email.impl;

import com.kowalczyk.workouter.services.notification.email.EmailSenderService;
import com.kowalczyk.workouter.services.notification.email.GenericEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by JK on 2017-09-16.
 */
@Service
public abstract class GenericEmailServiceImpl implements GenericEmailService {

    private EmailSenderService emailSenderService;
    private JavaMailSender javaMailSender;

    @Autowired
    public GenericEmailServiceImpl(EmailSenderService emailSenderService, JavaMailSender javaMailSender) {
        this.emailSenderService = emailSenderService;
        this.javaMailSender = javaMailSender;
    }

    public EmailSenderService getEmailSenderService() {
        return emailSenderService;
    }

    @Override
    public MimeMessage prepareMessage(String email, String body, String subject) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setTo(email);
        return mimeMessage;
    }

    @Override
    public void sendMessage(MimeMessage mimeMessage) {
        emailSenderService.sendEmail(mimeMessage);
    }
}
