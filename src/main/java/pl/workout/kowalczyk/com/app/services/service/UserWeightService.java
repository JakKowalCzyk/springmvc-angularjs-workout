package pl.workout.kowalczyk.com.app.services.service;

import pl.workout.kowalczyk.com.app.model.data.model.entity.UserWeight;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
public interface UserWeightService {
    void saveUserWeight(UserWeight userWeight);

    void updateUserWeight(UserWeight userWeight);

    List<UserWeight> getWeightByUserId(int userId);

    UserWeight getByUserIdAndDate(int userId, Date date);
}
