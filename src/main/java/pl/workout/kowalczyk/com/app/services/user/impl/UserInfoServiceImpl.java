package pl.workout.kowalczyk.com.app.services.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.workout.kowalczyk.com.app.dao.user.UserInfoDao;
import pl.workout.kowalczyk.com.app.model.BO.user.UserInfo;
import pl.workout.kowalczyk.com.app.services.impl.ModelServiceImpl;
import pl.workout.kowalczyk.com.app.services.user.UserInfoService;

/**
 * Created by JK on 2016-10-26.
 */
@Service
public class UserInfoServiceImpl extends ModelServiceImpl<UserInfo> implements UserInfoService {

    @Autowired
    public UserInfoServiceImpl(UserInfoDao baseDao) {
        super(baseDao);
    }

    public UserInfo getUserInfoByUserId(Long userId) {
        return ((UserInfoDao) getBaseDao()).getUserInfoByUserId(userId);
    }

}
