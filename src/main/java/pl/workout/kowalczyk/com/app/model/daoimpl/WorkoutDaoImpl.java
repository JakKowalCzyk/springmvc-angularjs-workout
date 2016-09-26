package pl.workout.kowalczyk.com.app.model.daoimpl;

import org.jsoup.Connection;
import pl.workout.kowalczyk.com.app.model.dao.WorkoutDao;
import pl.workout.kowalczyk.com.app.model.entity.UserExercise;
import pl.workout.kowalczyk.com.app.model.entity.Workout;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-09-26.
 */
public class WorkoutDaoImpl extends BaseDaoImpl<Workout> implements WorkoutDao{

    private static final String getByUserIdSql = "";
    private static final String getByDateSql = "";
    private static final String getUserExercises = "";

    @PersistenceContext
    private EntityManager entityManager;

    public List<Workout> getWorkoutsByUserId(int userId) {
        return null;
    }

    public Workout getByUserIdAndDate(int userId, Date date) {
        return null;
    }

    public List<UserExercise> getUserExercisesByIdAndDate(int userId, Date date) {
        return null;
    }
}
