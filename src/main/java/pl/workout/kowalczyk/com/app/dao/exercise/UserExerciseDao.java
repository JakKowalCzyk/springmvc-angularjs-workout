package pl.workout.kowalczyk.com.app.dao.exercise;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.workout.kowalczyk.com.app.dao.BaseDao;
import pl.workout.kowalczyk.com.app.model.BO.exercise.UserExercise;

import java.util.List;

/**
 * Created by JK on 2016-09-22.
 */
public interface UserExerciseDao extends BaseDao<UserExercise> {

    @Query("SELECT o FROM UserExercise o inner join o.workoutId as workout" +
            " inner join workout.userId as user where user.id = :userId")
    List<UserExercise> getUserExercisesByUserId(@Param("userId") Integer userId);

    @Transactional
    @Modifying
    @Query("UPDATE UserExercise exercise set exercise.repeat =:repeat, exercise.series =:series where exercise.id =:exerciseId ")
    void updateUserExerciseWithRepeatAndSeries(@Param("exerciseId") Integer exerciseId, @Param("repeat") Integer repeat, @Param("series") Integer series);
}
