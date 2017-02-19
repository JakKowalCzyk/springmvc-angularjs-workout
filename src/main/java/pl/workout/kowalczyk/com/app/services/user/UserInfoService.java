package pl.workout.kowalczyk.com.app.services.user;

import pl.workout.kowalczyk.com.app.model.BO.user.UserInfo;
import pl.workout.kowalczyk.com.app.services.ModelService;

/**
 * Created by JK on 2016-10-26.
 */
public interface UserInfoService extends ModelService<UserInfo> {

    UserInfo getUserInfoByUserId(Long userId);

}
