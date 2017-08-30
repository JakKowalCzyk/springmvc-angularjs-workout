package com.kowalczyk.workouter.dao.user;

import com.kowalczyk.workouter.dao.BaseDao;
import com.kowalczyk.workouter.model.BO.user.impl.UserWeight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by JK on 2016-09-22.
 */
@Repository
public interface UserWeightDAO extends BaseDao<UserWeight> {

    @Query("SELECT o FROM UserWeight o inner join o.user as user WHERE user.id = :userId")
    List<UserWeight> getWeightByUserId(@Param("userId") Long userId);

    @Query("SELECT o FROM UserWeight o inner join o.user userid WHERE userid.id = :userId and o.date = :date")
    UserWeight getByUserIdAndDate(@Param("userId") Long userId, @Param("date") Date date);

    @Query("SELECT o FROM UserWeight o join o.user userid where userid.id = :userId order by o.date desc ")
    List<UserWeight> getUserWeightListOrderedByDate(@Param("userId") Long userId);


}
