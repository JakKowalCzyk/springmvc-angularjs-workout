package com.kowalczyk.workouter.services.security;

import com.kowalczyk.workouter.model.BO.security.UserConfirmationToken;
import com.kowalczyk.workouter.model.BO.user.User;
import com.kowalczyk.workouter.services.ModelService;

/**
 * Created by JK on 2017-09-12.
 */
public interface UserConfirmationService extends ModelService<UserConfirmationToken> {

    void startConfirmationProcess(User user, String uri);

}
