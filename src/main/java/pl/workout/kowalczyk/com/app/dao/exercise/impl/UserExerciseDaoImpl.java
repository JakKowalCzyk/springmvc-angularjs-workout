package pl.workout.kowalczyk.com.app.dao.exercise.impl;

import org.springframework.stereotype.Repository;
import pl.workout.kowalczyk.com.app.dao.impl.BaseDaoImpl;
import pl.workout.kowalczyk.com.app.dao.exercise.UserExerciseDao;
import pl.workout.kowalczyk.com.app.model.BO.exercise.UserExercise;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by JK on 2016-09-26.
 */
//TODO exception in delete, need to test services
@Repository
public class UserExerciseDaoImpl extends BaseDaoImpl<UserExercise> implements UserExerciseDao{

    private static final String getByIdSql = "SELECT o FROM UserExercise o inner join o.workout_id as workout" +
            " inner join workout.user_id as user where user.userId = :userId";

    @PersistenceContext
    private EntityManager entityManager;

    public List<UserExercise> getUserExercisesByUserId(int userId) {
        TypedQuery<UserExercise> typedQuery = entityManager.createQuery(getByIdSql, UserExercise.class);
        typedQuery.setParameter("userId", userId);
        List<UserExercise> userExercises = typedQuery.getResultList();
        return userExercises;
    }


}
