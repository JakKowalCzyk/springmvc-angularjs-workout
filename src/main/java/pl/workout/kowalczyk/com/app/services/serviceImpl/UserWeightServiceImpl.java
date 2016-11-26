package pl.workout.kowalczyk.com.app.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.workout.kowalczyk.com.app.dao.UserDao;
import pl.workout.kowalczyk.com.app.dao.UserInfoDao;
import pl.workout.kowalczyk.com.app.dao.UserWeightDao;
import pl.workout.kowalczyk.com.app.model.BO.UserWeight;
import pl.workout.kowalczyk.com.app.model.DTO.UserWeightDTO;
import pl.workout.kowalczyk.com.app.services.service.UserInfoService;
import pl.workout.kowalczyk.com.app.services.service.UserWeightService;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by JK on 2016-10-26.
 */
@Service
@Transactional
public class UserWeightServiceImpl implements UserWeightService {
    @Autowired
    private UserWeightDao userWeightDao;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private UserDao userDao;

    @Override
    public UserWeight mapUserWeightDtoToBo(UserWeightDTO actual_weight) {
        return new UserWeight(userDao.get(actual_weight.getUserId()), actual_weight.getWeightKg(), actual_weight.getDate());
    }

    @Override
    public UserWeightDTO mapUserWeightBoToDto(UserWeight actual_weight) {
        return new UserWeightDTO(actual_weight.getWeight_id(), actual_weight.getUser_id().getUser_id(), actual_weight.getWeight_kg(), actual_weight.getDate());
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
        userWeight.setWeight_id(userWeightDTO.getWeightId());
        userWeightDao.update(userWeight);
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
        if (getLastDate(userId).after(userWeight.getDate())) {
            return false;
        }else{
            return true;
        }
    }

    public Date getLastDate(int userId) {
        return userWeightDao.getLastUserWeight(userId).getDate();
    }
}
