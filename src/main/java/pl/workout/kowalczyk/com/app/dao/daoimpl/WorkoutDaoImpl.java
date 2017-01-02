package pl.workout.kowalczyk.com.app.dao.daoimpl;

import org.springframework.stereotype.Repository;
import pl.workout.kowalczyk.com.app.dao.WorkoutDao;
import pl.workout.kowalczyk.com.app.model.BO.Workout;
import pl.workout.kowalczyk.com.app.model.BO.UserExercise;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-09-26.
 */
@Repository
public class WorkoutDaoImpl extends BaseDaoImpl<Workout> implements WorkoutDao {

    private static final String getByUserIdSql = "SELECT o FROM Workout o inner join o.user_id as user" +
            " where user.userId = :userId";
    private static final String getByDateSql = "SELECT o FROM Workout  o inner join o.user_id as user where user.userId = :userId and o.date = :date";
    private static final String getUserExercises = "SELECT o FROM UserExercise o inner join o.workout_id as workout " +
            "inner join workout.user_id as user " +
            "where user.userId = :userId and workout.date = :date";

    @PersistenceContext
    private EntityManager entityManager;

    public List<Workout> getWorkoutsByUserId(int userId) {
        TypedQuery<Workout> typedQuery = entityManager.createQuery(getByUserIdSql, Workout.class);
        typedQuery.setParameter("userId", userId);
        List<Workout> workouts = typedQuery.getResultList();
        return workouts;
    }

    public Workout getByUserIdAndDate(int userId, Date date) {
        TypedQuery<Workout> typedQuery = entityManager.createQuery(getByDateSql, Workout.class);
        setUserIdAndDate(userId, date, typedQuery);
        Workout workout = typedQuery.getSingleResult();
        return workout;
    }

    public List<UserExercise> getUserExercisesByIdAndDate(int userId, Date date) {
        TypedQuery<UserExercise> typedQuery = entityManager.createQuery(getUserExercises, UserExercise.class);
        setUserIdAndDate(userId, date, typedQuery);
        List<UserExercise> userExercises = typedQuery.getResultList();
        return userExercises;
    }

    private void setUserIdAndDate(int userId, Date date, TypedQuery<?> typedQuery) {
        typedQuery.setParameter("userId", userId);
        typedQuery.setParameter("date", date);
    }
}
