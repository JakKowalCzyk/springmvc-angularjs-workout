package pl.workout.kowalczyk.com.app.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.workout.kowalczyk.com.app.model.data.model.dao.UserWeightDao;
import pl.workout.kowalczyk.com.app.model.data.model.entity.UserWeight;
import pl.workout.kowalczyk.com.app.services.service.UserWeightService;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
@Service
@Transactional
public class UserWeightServiceImpl implements UserWeightService {
    @Autowired
    private UserWeightDao userWeightDao;

    public void saveUserWeight(UserWeight userWeight) {
        userWeightDao.save(userWeight);
    }

    public void updateUserWeight(UserWeight userWeight) {
        userWeightDao.update(userWeight);
    }

    public List<UserWeight> getWeightByUserId(int userId) {
        return userWeightDao.getWeightByUserId(userId);
    }

    public UserWeight getByUserIdAndDate(int userId, Date date) {
        return userWeightDao.getByUserIdAndDate(userId, date);
    }
}
