package pl.workout.kowalczyk.com.app.model.dao;

import pl.workout.kowalczyk.com.app.model.entity.UserWeight;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-09-22.
 */
public interface UserWeightDao extends BaseDao<UserWeight> {
    List<UserWeight> getWeightByUserId(int userId);

    UserWeight getByUserIdAndDate(int userId, Date date);


}
