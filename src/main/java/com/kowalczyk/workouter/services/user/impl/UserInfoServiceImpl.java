package com.kowalczyk.workouter.services.user.impl;

import com.kowalczyk.workouter.dao.user.UserInfoDAO;
import com.kowalczyk.workouter.model.BO.user.impl.UserInfo;
import com.kowalczyk.workouter.services.impl.ModelServiceImpl;
import com.kowalczyk.workouter.services.user.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by JK on 2016-10-26.
 */
@Service
public class UserInfoServiceImpl extends ModelServiceImpl<UserInfo> implements UserInfoService {

    @Autowired
    public UserInfoServiceImpl(UserInfoDAO baseDao) {
        super(baseDao);
    }

    public UserInfo getUserInfoByUserId(Long userId) {
        return ((UserInfoDAO) getBaseDAO()).getUserInfoByUserId(userId);
    }

}
