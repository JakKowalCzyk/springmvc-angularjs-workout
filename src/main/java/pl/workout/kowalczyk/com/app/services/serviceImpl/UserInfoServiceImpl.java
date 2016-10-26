package pl.workout.kowalczyk.com.app.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.workout.kowalczyk.com.app.model.data.model.dao.UserInfoDao;
import pl.workout.kowalczyk.com.app.model.data.model.entity.UserInfo;
import pl.workout.kowalczyk.com.app.services.service.UserInfoService;

/**
 * Created by JK on 2016-10-26.
 */
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;

    public void saveUserInfo(UserInfo userInfo) {
        userInfoDao.save(userInfo);
    }

    public void updateUserInfo(UserInfo userInfo) {
        userInfoDao.update(userInfo);
    }

    public UserInfo getUserInfoByUserId(int userId) {
        return userInfoDao.getUserInfoByUserId(userId);
    }
}
