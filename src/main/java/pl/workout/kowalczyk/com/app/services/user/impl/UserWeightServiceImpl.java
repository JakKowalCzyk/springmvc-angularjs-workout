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
        return new UserWeightDTO(actual_weight.getId(), actual_weight.getUser_id().getId(), actual_weight.getWeight_kg(), actual_weight.getDate());
    }

    public void saveUserWeight(int userId, UserWeightDTO userWeightDto) {
        UserWeight userWeight = mapUserWeightDtoToBo(userWeightDto);
        if (checkIfLastWeight(userId, userWeightDto)) {
            userInfoService.updateUserInfoWithUserWeight(userId, userWeight);
        }
            userWeightDao.save(userWeight);
    }

    public void updateUserWeight(UserWeightDTO userWeightDTO) {
        UserWeight userWeight = mapUserWeightDtoToBo(userWeightDTO);
        userWeight.setId(userWeightDTO.getId());
//        userWeightDao.update(userWeight);
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

    public boolean checkIfLastWeight(int userId, UserWeightDTO userWeight) {
        return !getLastDate(userId).after(userWeight.getDate());
    }

    public Date getLastDate(int userId) {
        return userWeightDao.getLastUserWeight(userId).getDate();
    }
}
