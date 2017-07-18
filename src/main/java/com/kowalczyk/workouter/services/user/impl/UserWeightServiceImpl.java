package com.kowalczyk.workouter.services.user.impl;

import com.kowalczyk.workouter.dao.user.UserWeightDao;
import com.kowalczyk.workouter.model.BO.user.impl.UserInfo;
import com.kowalczyk.workouter.model.BO.user.impl.UserWeight;
import com.kowalczyk.workouter.services.impl.ModelServiceImpl;
import com.kowalczyk.workouter.services.user.UserInfoService;
import com.kowalczyk.workouter.services.user.UserWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    public UserWeight getActualWeight(Long userId) {
        return userInfoService.getUserInfoByUserId(userId).getActualWeight();
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

    @Override
    public void deleteObject(Long id) {
        UserWeight userWeightToDelete = super.getObject(id);
        updateUserInfoWithNullWeight(userWeightToDelete);
        if (checkIfLastWeight(userWeightToDelete)) {
            deleteAndUpdateActualWeight(userWeightToDelete);
        } else {
            super.deleteObject(id);
        }
    }

    private void updateUserInfoWithNullWeight(UserWeight userWeightToDelete) {
        UserInfo userInfo = userInfoService.getUserInfoByUserId(userWeightToDelete.getUser().getId());
        userInfo.setActualWeight(null);
        userInfoService.updateObject(userInfo);
    }

    private void deleteAndUpdateActualWeight(UserWeight userWeightToDelete) {
        super.deleteObject(userWeightToDelete);
        Optional<UserWeight> userWeightOptional = getUserWeightWitLastDate(userWeightToDelete.getUser().getId());
        userWeightOptional.ifPresent(this::setActualWeight);
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

    public boolean checkIfLastWeight(UserWeight userWeight) {
        Optional<UserWeight> dateOptional = getUserWeightWitLastDate(userWeight.getUser().getId());
        return !dateOptional.isPresent() || !dateOptional.get().getDate().after(userWeight.getDate());
    }

    public Optional<UserWeight> getUserWeightWitLastDate(Long userId) {
        return ((UserWeightDao) getBaseDao()).getUserWeightListOrderedByDate(userId).stream().findFirst();
    }
}
