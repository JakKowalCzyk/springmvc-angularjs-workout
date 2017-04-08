package pl.workout.kowalczyk.com.app.mapper.user.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import pl.workout.kowalczyk.com.app.mapper.AbstractMapperTest;
import pl.workout.kowalczyk.com.app.model.BO.user.impl.UserInfo;
import pl.workout.kowalczyk.com.app.model.DTO.user.impl.UserInfoDTO;
import pl.workout.kowalczyk.com.app.services.exercise.ExerciseService;
import pl.workout.kowalczyk.com.app.services.user.UserWeightService;

import static org.junit.Assert.assertEquals;

/**
 * Created by JK on 2017-04-08.
 */
public class UserInfoMapperTest extends AbstractMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserWeightService userWeightService;
    @Autowired
    private ExerciseService exerciseService;

    @Override
    @Before
    public void setUp() throws Exception {
        Mockito.when(userWeightService.getObject(Mockito.anyLong())).thenReturn(getUserWeightTest());
        Mockito.when(exerciseService.getObject(Mockito.anyLong())).thenReturn(getExerciseTest());
        super.setUp();
    }

    @Test
    public void mapToBO() throws Exception {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setId(3L);
        userInfoDTO.setUserId(getUserDetailsTest().getId());
        userInfoDTO.setActualWeightId(getUserWeightTest().getId());
        userInfoDTO.setFavouriteExerciseId(getExerciseTest().getId());
        UserInfo userInfo = userInfoMapper.mapToBO(userInfoDTO);
        assertEquals(userInfoDTO.getId(), userInfo.getId());
        assertEquals(userInfoDTO.getUserId(), userInfo.getUser().getId());
        assertEquals(userInfoDTO.getActualWeightId(), userInfo.getActualWeight().getId());
        assertEquals(userInfoDTO.getFavouriteExerciseId(), userInfo.getExerciseFavouriteId().getId());
    }

    @Test
    public void mapToDTO() throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(3L);
        userInfo.setUser(getUserDetailsTest());
        userInfo.setActualWeight(getUserWeightTest());
        userInfo.setExerciseFavouriteId(getExerciseTest());
        UserInfoDTO userInfoDTO = userInfoMapper.mapToDTO(userInfo);
        assertEquals(userInfo.getId(), userInfoDTO.getId());
        assertEquals(userInfo.getUser().getId(), userInfoDTO.getUserId());
        assertEquals(userInfo.getActualWeight().getId(), userInfoDTO.getActualWeightId());
        assertEquals(userInfo.getExerciseFavouriteId().getId(), userInfoDTO.getFavouriteExerciseId());
    }

}