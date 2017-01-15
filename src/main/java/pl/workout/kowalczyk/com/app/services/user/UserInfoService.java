package pl.workout.kowalczyk.com.app.services.user;

import pl.workout.kowalczyk.com.app.model.BO.user.UserInfo;
import pl.workout.kowalczyk.com.app.model.BO.user.UserWeight;
import pl.workout.kowalczyk.com.app.model.DTO.user.UserInfoDTO;

/**
 * Created by JK on 2016-10-26.
 */
public interface UserInfoService {

    UserInfoDTO mapUserInfoBoToDto(UserInfo userInfo);

    UserInfo mapUserInfoDtoToBo(UserInfoDTO userInfoDTO);

    void saveUserInfo(UserInfoDTO userInfo);

    UserInfoDTO getUserInfoDTOByUserId(int userId);

    UserInfo getUserInfoByUserId(int userId);

    void updateUserInfoWithUserWeight(int userId, UserWeight userWeight);
}
