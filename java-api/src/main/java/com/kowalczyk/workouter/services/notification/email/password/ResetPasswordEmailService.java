package com.kowalczyk.workouter.services.notification.email.password;

import com.kowalczyk.workouter.model.BO.security.token.ResetPasswordToken;
import com.kowalczyk.workouter.services.notification.email.GenericEmailService;

/**
 * Created by JK on 2018-01-15.
 */
public interface ResetPasswordEmailService extends GenericEmailService {

    void sendResetPasswordEmail(ResetPasswordToken resetPasswordToken, String body);
}
