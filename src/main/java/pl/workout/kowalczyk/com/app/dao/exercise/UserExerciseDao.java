package pl.workout.kowalczyk.com.app.dao.exercise;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.workout.kowalczyk.com.app.dao.BaseDao;
import pl.workout.kowalczyk.com.app.model.BO.exercise.UserExercise;

import java.util.List;

/**
 * Created by JK on 2016-09-22.
 */
public interface UserExerciseDao extends BaseDao<UserExercise> {

    @Query("SELECT o FROM UserExercise o inner join o.workoutId as workout" +
            " inner join workout.userId as user where user.id = :userId")
    List<UserExercise> getUserExercisesByUserId(@Param("userId") int userId);

}
