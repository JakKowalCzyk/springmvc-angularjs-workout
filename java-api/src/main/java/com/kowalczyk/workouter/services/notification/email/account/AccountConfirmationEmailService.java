package com.kowalczyk.workouter.services.notification.email.account;

import com.kowalczyk.workouter.model.BO.security.token.UserConfirmationToken;
import com.kowalczyk.workouter.services.notification.email.GenericEmailService;

/**
 * Created by JK on 2017-09-16.
 */
public interface AccountConfirmationEmailService extends GenericEmailService {

    void sendEmailToUserWithConfirmationLink(UserConfirmationToken userConfirmationToken, String uri);

}
