package pl.workout.kowalczyk.com.app.dao.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.workout.kowalczyk.com.app.dao.BaseDao;
import pl.workout.kowalczyk.com.app.model.BO.user.UserWeight;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-09-22.
 */
public interface UserWeightDao extends BaseDao<UserWeight> {

    @Query("SELECT o FROM UserWeight o inner join o.userId as user WHERE user.id = :userId")
    List<UserWeight> getWeightByUserId(@Param("userId") Long userId);

    @Query("SELECT o FROM UserWeight o inner join o.userId userid WHERE userid.id = :userId and o.date = :date")
    UserWeight getByUserIdAndDate(@Param("userId") Long userId, @Param("date") Date date);

    @Query("SELECT o FROM UserWeight o join o.userId userid where userid.id = :userId order by o.date desc ")
    List<UserWeight> getUserWeightListOrderedByDate(@Param("userId") Long userId);


}
