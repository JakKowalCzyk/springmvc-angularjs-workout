package pl.workout.kowalczyk.com.app.services;

import pl.workout.kowalczyk.com.app.model.BO.UserInfo;
import pl.workout.kowalczyk.com.app.model.BO.UserWeight;
import pl.workout.kowalczyk.com.app.model.DTO.UserInfoDTO;

/**
 * Created by JK on 2016-10-26.
 */
public interface UserInfoService {

    UserInfoDTO mapUserInfoBoToDto(UserInfo userInfo);

    UserInfo mapUserInfoDtoToBo(UserInfoDTO userInfoDTO);

    void saveUserInfo(UserInfoDTO userInfo);

    void updateUserInfoDTO(UserInfoDTO userInfoDTO);

    void updateUserInfo(UserInfo userInfo);

    UserInfoDTO getUserInfoDTOByUserId(int userId);

    UserInfo getUserInfoByUserId(int userId);

    void updateUserInfoWithUserWeight(int userId, UserWeight userWeight);
}
