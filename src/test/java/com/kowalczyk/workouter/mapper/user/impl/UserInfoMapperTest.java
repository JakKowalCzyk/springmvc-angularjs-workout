package com.kowalczyk.workouter.mapper.user.impl;

import com.kowalczyk.workouter.mapper.AbstractMapperTest;
import com.kowalczyk.workouter.model.BO.user.impl.UserInfo;
import com.kowalczyk.workouter.model.DTO.user.impl.UserInfoDTO;
import com.kowalczyk.workouter.services.exercise.ExerciseService;
import com.kowalczyk.workouter.services.user.UserDetailsService;
import com.kowalczyk.workouter.services.user.UserWeightService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

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
    @Autowired
    private UserDetailsService userDetailsService;
    @Override
    @Before
    public void setUp() throws Exception {
        Mockito.when(userWeightService.getObject(Mockito.anyLong())).thenReturn(getUserWeightTest());
        Mockito.when(exerciseService.getObject(Mockito.anyLong())).thenReturn(getExerciseTest());
        Mockito.when(userDetailsService.getObject(Mockito.anyLong())).thenReturn(getUserDetailsTest());
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
        Assert.assertEquals(userInfoDTO.getUserId(), userInfo.getUser().getId());
        Assert.assertEquals(userInfoDTO.getActualWeightId(), userInfo.getActualWeight().getId());
        Assert.assertEquals(userInfoDTO.getFavouriteExerciseId(), userInfo.getExerciseFavouriteId().getId());
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
        Assert.assertEquals(userInfo.getUser().getId(), userInfoDTO.getUserId());
        Assert.assertEquals(userInfo.getActualWeight().getId(), userInfoDTO.getActualWeightId());
        Assert.assertEquals(userInfo.getExerciseFavouriteId().getId(), userInfoDTO.getFavouriteExerciseId());
    }

}