package com.kowalczyk.workouter.services.user;

import com.kowalczyk.workouter.model.BO.user.impl.UserInfo;
import com.kowalczyk.workouter.services.ModelService;

/**
 * Created by JK on 2016-10-26.
 */
public interface UserInfoService extends ModelService<UserInfo> {

    UserInfo getUserInfoByUserId(Long userId);

}
