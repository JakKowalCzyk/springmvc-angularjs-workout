package pl.workout.kowalczyk.com.app.services.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.workout.kowalczyk.com.app.dao.user.UserWeightDao;
import pl.workout.kowalczyk.com.app.model.BO.user.UserWeight;
import pl.workout.kowalczyk.com.app.services.impl.ModelServiceImpl;
import pl.workout.kowalczyk.com.app.services.user.UserInfoService;
import pl.workout.kowalczyk.com.app.services.user.UserWeightService;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
@Service
public class UserWeightServiceImpl extends ModelServiceImpl<UserWeight> implements UserWeightService {
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    public UserWeightServiceImpl(UserWeightDao baseDao) {
        super(baseDao);
    }

    public List<UserWeight> getWeightByUserId(Long userId) {
        return ((UserWeightDao) getBaseDao()).getWeightByUserId(userId);
    }

    public UserWeight getByUserIdAndDate(Long userId, Date date) {
        return ((UserWeightDao) getBaseDao()).getByUserIdAndDate(userId, date);
    }

    @Override
    public UserWeight getActualWeight(Long userId) {
        return userInfoService.getObject(userId).getActualWeight();
    }

    public boolean checkIfLastWeight(UserWeight userWeight) {
        return !getLastDate(userWeight.getUserId().getId()).after(userWeight.getDate());
    }

    public Date getLastDate(Long userId) {
        List<UserWeight> userWeights = ((UserWeightDao) getBaseDao()).getUserWeightListOrderedByDate(userId);
        return userWeights.stream().findFirst().get().getDate();
    }
}
