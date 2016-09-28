package pl.workout.kowalczyk.com.app.model.daoimpl;

import org.springframework.stereotype.Repository;
import pl.workout.kowalczyk.com.app.model.dao.BaseDao;
import pl.workout.kowalczyk.com.app.model.dao.UserExerciseDao;
import pl.workout.kowalczyk.com.app.model.entity.Exercise;
import pl.workout.kowalczyk.com.app.model.entity.UserExercise;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-09-26.
 */
@Repository
public class UserExerciseDaoImpl extends BaseDaoImpl<UserExercise> implements UserExerciseDao{

    private static final String getByIdSql = "SELECT o FROM UserExercise o WHERE o.user_id = :userId";
    private static final String getByDate = "SELECT o FROM UserExercise o WHERE o.user_id = :userId AND o.date = :date";

    @PersistenceContext
    private EntityManager entityManager;

    public List<UserExercise> getUserExercisesByUserId(int userId) {
        TypedQuery<UserExercise> typedQuery = getUserExerciseTypedQuery(getByIdSql);
        typedQuery.setParameter("userId", userId);
        List<UserExercise> userExercises = typedQuery.getResultList();
        return userExercises;
    }

    public List<UserExercise> getByDate(int userId, Date date) {
        TypedQuery<UserExercise> typedQuery = getUserExerciseTypedQuery(getByDate);
        typedQuery.setParameter("userId", userId);
        typedQuery.setParameter("date", date);
        List<UserExercise> userExercises = typedQuery.getResultList();
        return userExercises;
    }

    private TypedQuery<UserExercise> getUserExerciseTypedQuery(String getByIdSql) {
        return entityManager.createQuery(getByIdSql, UserExercise.class);
    }
}
