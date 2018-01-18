package com.kowalczyk.workouter.services.security.token.impl;

import com.kowalczyk.workouter.dao.security.token.ResetPasswordTokenDAO;
import com.kowalczyk.workouter.model.BO.security.token.ResetPasswordToken;
import com.kowalczyk.workouter.model.BO.user.User;
import com.kowalczyk.workouter.services.notification.email.password.ResetPasswordEmailService;
import com.kowalczyk.workouter.services.security.token.ResetPasswordService;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.GregorianCalendar;
import java.util.UUID;

/**
 * Created by JK on 2018-01-14.
 */
@Service
public class ResetPasswordServiceImpl extends GenericTokenServiceImpl<ResetPasswordToken> implements ResetPasswordService {

    private ResetPasswordEmailService resetPasswordEmailService;

    @Autowired
    public ResetPasswordServiceImpl(ResetPasswordTokenDAO baseDAO, ResetPasswordEmailService resetPasswordEmailService) {
        super(baseDAO);
        this.resetPasswordEmailService = resetPasswordEmailService;
    }

    @Override
    public ResetPasswordToken getNewToken(User user) {
        ResetPasswordToken resetPasswordToken = new ResetPasswordToken();
        resetPasswordToken.setUser(user);
        resetPasswordToken.setToken(UUID.randomUUID().toString());
        resetPasswordToken.setExpiryDate(DateUtils.addHours(new GregorianCalendar().getTime(), 1));
        addObject(resetPasswordToken);
        return resetPasswordToken;
    }

    @Override
    public void sendMessageWithToken(ResetPasswordToken token, String preparedUri) {
        resetPasswordEmailService.sendResetPasswordEmail(token, preparedUri);
    }
}
