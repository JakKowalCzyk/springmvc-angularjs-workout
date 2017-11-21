package com.kowalczyk.workouter.services.notification.email;

import javax.mail.internet.MimeMessage;

/**
 * Created by JK on 2017-09-12.
 */
public interface EmailSenderService {

    void sendEmail(MimeMessage mimeMessage);

}
