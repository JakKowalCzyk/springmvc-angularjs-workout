package pl.workout.kowalczyk.com.app.model.data.daoimpl;

import org.springframework.stereotype.Repository;
import pl.workout.kowalczyk.com.app.model.data.dao.WorkoutDao;
import pl.workout.kowalczyk.com.app.model.data.entity.Workout;
import pl.workout.kowalczyk.com.app.model.data.entity.UserExercise;

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

    private static final String getByUserIdSql = "SELECT o FROM Workout o where o.user_id = :userId";
    private static final String getByDateSql = "SELECT o FROM Workout  o where o.user_id = :userId and o.date = :date";
    private static final String getUserExercises = "SELECT o FROM UserExercise as o inner join Workout as w on  o.workout_id =  w " +
            "where w.user_id = :userId and w.date = :date";

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
