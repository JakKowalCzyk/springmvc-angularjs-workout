package pl.workout.kowalczyk.com.app.mapper.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.workout.kowalczyk.com.app.mapper.impl.ModelMapperImpl;
import pl.workout.kowalczyk.com.app.model.BO.user.UserInfo;
import pl.workout.kowalczyk.com.app.model.DTO.user.UserInfoDTO;
import pl.workout.kowalczyk.com.app.services.exercise.ExerciseService;
import pl.workout.kowalczyk.com.app.services.user.UserWeightService;
import pl.workout.kowalczyk.com.app.services.user.security.UserDetailsService;

/**
 * Created by JK on 2017-02-18.
 */
@Component
public class UserInfoMapper extends ModelMapperImpl<UserInfo, UserInfoDTO> {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserWeightService userWeightService;
    @Autowired
    private ExerciseService exerciseService;

    @Override
    protected UserInfo buildBO(UserInfoDTO objectDTO) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userDetailsService.getObject(objectDTO.getUserId()));
        userInfo.setActualWeight(userWeightService.getObject(objectDTO.getActualWeightId()));
        userInfo.setExerciseFavouriteId(exerciseService.getObject(objectDTO.getFavouriteExerciseId()));
        return userInfo;
    }

    @Override
    protected UserInfoDTO buildDTO(UserInfo modelObject) {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setActualWeightId(modelObject.getActualWeight().getId());
        userInfoDTO.setFavouriteExerciseId(modelObject.getExerciseFavouriteId().getId());
        userInfoDTO.setUserId(modelObject.getUserId().getId());
        return userInfoDTO;
    }
}
