package pl.workout.kowalczyk.com.app.services.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.workout.kowalczyk.com.app.dao.user.UserWeightDao;
import pl.workout.kowalczyk.com.app.model.BO.user.impl.UserInfo;
import pl.workout.kowalczyk.com.app.model.BO.user.impl.UserWeight;
import pl.workout.kowalczyk.com.app.services.impl.ModelServiceImpl;
import pl.workout.kowalczyk.com.app.services.user.UserInfoService;
import pl.workout.kowalczyk.com.app.services.user.UserWeightService;

import java.util.Date;
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

    @Override
    public UserWeight addObject(UserWeight baseModel) {
        if (checkIfLastWeight(baseModel)) {
            return addActualUserWeight(baseModel);
        }
        return super.addObject(baseModel);
    }

    @Override
    public UserWeight updateObject(UserWeight baseModel) {
        if (checkIfLastWeight(baseModel)) {
            updateActualUserWeight(baseModel);
        }
        return super.updateObject(baseModel);
    }

    private UserWeight updateActualUserWeight(UserWeight baseModel) {
        UserWeight userWeight = super.updateObject(baseModel);
        setActualWeight(userWeight);
        return userWeight;
    }

    private UserWeight addActualUserWeight(UserWeight baseModel) {
        UserWeight userWeight = super.addObject(baseModel);
        setActualWeight(userWeight);
        return userWeight;
    }

    private void setActualWeight(UserWeight baseModel) {
        UserInfo userInfo = userInfoService.getUserInfoByUserId(baseModel.getUser().getId());
        userInfo.setActualWeight(baseModel);
        userInfoService.updateObject(userInfo);
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
        return !getLastDate(userWeight.getUser().getId()).after(userWeight.getDate());
    }

    public Date getLastDate(Long userId) {
        List<UserWeight> userWeights = ((UserWeightDao) getBaseDao()).getUserWeightListOrderedByDate(userId);
        return userWeights.stream().findFirst().get().getDate();
    }
}
