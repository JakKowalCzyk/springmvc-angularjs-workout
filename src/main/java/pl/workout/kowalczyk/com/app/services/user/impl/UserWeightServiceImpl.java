package pl.workout.kowalczyk.com.app.services.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.workout.kowalczyk.com.app.dao.security.UserDetailsDao;
import pl.workout.kowalczyk.com.app.dao.user.UserInfoDao;
import pl.workout.kowalczyk.com.app.dao.user.UserWeightDao;
import pl.workout.kowalczyk.com.app.model.BO.user.UserWeight;
import pl.workout.kowalczyk.com.app.model.DTO.user.UserWeightDTO;
import pl.workout.kowalczyk.com.app.services.user.UserInfoService;
import pl.workout.kowalczyk.com.app.services.user.UserWeightService;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by JK on 2016-10-26.
 */
@Service
public class UserWeightServiceImpl implements UserWeightService {
    @Autowired
    private UserWeightDao userWeightDao;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private UserDetailsDao userDetailsDao;

    @Override
    public UserWeight mapUserWeightDtoToBo(UserWeightDTO actual_weight) {
        return new UserWeight(userDetailsDao.findOne(actual_weight.getUserId()), actual_weight.getWeightKg(), actual_weight.getDate());
    }

    @Override
    public UserWeightDTO mapUserWeightBoToDto(UserWeight actual_weight) {
        return new UserWeightDTO(actual_weight.getId(), actual_weight.getUserId().getId(), actual_weight.getWeightKg(), actual_weight.getDate());
    }

    @Override
    public UserWeight getUserWeightById(Integer weightId) {
        return userWeightDao.findOne(weightId);
    }

    public void saveUserWeight(UserWeightDTO userWeightDto) {
        UserWeight userWeight = mapUserWeightDtoToBo(userWeightDto);
        userWeightDao.save(userWeight);
        if (checkIfLastWeight(userWeightDto)) {
            userInfoService.updateUserInfoWithUserWeight(userWeight);
        }
    }

    public void updateUserWeight(UserWeightDTO userWeightDTO) {
        userWeightDao.updateUserWeight(userWeightDTO.getId(), userWeightDTO.getWeightKg());
    }

    public List<UserWeightDTO> getWeightByUserId(int userId) {
        return userWeightDao.getWeightByUserId(userId).stream().map(this::mapUserWeightBoToDto).collect(Collectors.toList());
    }

    public UserWeightDTO getByUserIdAndDate(int userId, Date date) {
        return mapUserWeightBoToDto(userWeightDao.getByUserIdAndDate(userId, date));
    }

    @Override
    public UserWeightDTO getActualWeight(int userId) {
        return mapUserWeightBoToDto(userInfoDao.getActualWeight(userId));
    }

    public boolean checkIfLastWeight(UserWeightDTO userWeight) {
        return !getLastDate(userWeight.getUserId()).after(userWeight.getDate());
    }

    public Date getLastDate(int userId) {
        List<UserWeight> userWeights = userWeightDao.getUserWeightListOrderedByDate(userId);
        return userWeights.stream().findFirst().get().getDate();
    }
}
