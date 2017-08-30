package com.kowalczyk.workouter.dao.exercise;

import com.kowalczyk.workouter.dao.BaseDao;
import com.kowalczyk.workouter.model.BO.exercise.Workout;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by JK on 2016-09-22.
 */
public interface WorkoutDAO extends BaseDao<Workout> {

    @Query("SELECT o FROM Workout o inner join o.user as user where user.id = :userId")
    List<Workout> getWorkoutsByUserId(@Param("userId") Long userId);

}
