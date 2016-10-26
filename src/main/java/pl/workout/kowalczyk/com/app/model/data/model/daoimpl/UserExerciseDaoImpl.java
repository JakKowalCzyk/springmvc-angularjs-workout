package pl.workout.kowalczyk.com.app.model.data.model.daoimpl;

import org.springframework.stereotype.Repository;
import pl.workout.kowalczyk.com.app.model.data.model.dao.UserExerciseDao;
import pl.workout.kowalczyk.com.app.model.data.model.entity.UserExercise;

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

    @PersistenceContext
    private EntityManager entityManager;

    public List<UserExercise> getUserExercisesByUserId(int userId) {
        TypedQuery<UserExercise> typedQuery = entityManager.createQuery(getByIdSql, UserExercise.class);
        typedQuery.setParameter("userId", userId);
        List<UserExercise> userExercises = typedQuery.getResultList();
        return userExercises;
    }


}
