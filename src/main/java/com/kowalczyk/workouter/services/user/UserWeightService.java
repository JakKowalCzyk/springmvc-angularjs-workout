package com.kowalczyk.workouter.services.user;

import com.kowalczyk.workouter.model.BO.user.impl.UserWeight;
import com.kowalczyk.workouter.services.ModelService;

import java.util.Date;
import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
public interface UserWeightService extends ModelService<UserWeight> {

    @Override
    UserWeight addObject(UserWeight baseModel);

    @Override
    UserWeight updateObject(UserWeight baseModel);

    List<UserWeight> getWeightByUserId(Long userId);

    UserWeight getByUserIdAndDate(Long userId, Date date);

    UserWeight getActualWeight(Long userId);

    Date getLastDate(Long userId);

    boolean checkIfLastWeight(UserWeight userWeight);
}
