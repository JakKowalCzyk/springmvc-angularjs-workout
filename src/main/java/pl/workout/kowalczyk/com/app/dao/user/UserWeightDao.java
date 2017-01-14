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

    @Query("SELECT o FROM UserWeight o inner join o.user_id as user WHERE user.id = :userId")
    List<UserWeight> getWeightByUserId(@Param("userId") int userId);

    @Query("SELECT o FROM UserWeight o inner join o.user_id userid WHERE userid.id = :userId and o.date = :date")
    UserWeight getByUserIdAndDate(@Param("userId") int userId, @Param("date") Date date);

    @Query("SELECT o FROM UserWeight o join o.user_id userid where userid.id = :userId order by o.date  ")
    UserWeight getLastUserWeight(@Param("userId") int userId);
}
