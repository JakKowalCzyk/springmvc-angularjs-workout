package pl.workout.kowalczyk.com.app.services.service;

import pl.workout.kowalczyk.com.app.model.data.entity.UserInfo;

/**
 * Created by JK on 2016-10-26.
 */
public interface UserInfoService {
    void saveUserInfo(UserInfo userInfo);

    void updateUserInfo(UserInfo userInfo);

    UserInfo getUserInfoByUserId(int userId);
}