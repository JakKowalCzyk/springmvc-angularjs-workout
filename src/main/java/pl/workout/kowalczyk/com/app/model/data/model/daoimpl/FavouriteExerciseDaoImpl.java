package pl.workout.kowalczyk.com.app.model.data.model.daoimpl;

import org.springframework.stereotype.Repository;
import pl.workout.kowalczyk.com.app.model.data.model.dao.FavouriteExerciseDao;
import pl.workout.kowalczyk.com.app.model.data.model.entity.FavouriteExercise;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Created by JK on 2016-10-10.
 */
@Repository
public class FavouriteExerciseDaoImpl extends BaseDaoImpl<FavouriteExercise> implements FavouriteExerciseDao {

    private static final String getFavouriteExerciseByUserId = "SELECT o FROM FavouriteExercise o where o.user_id = :userId";


    @PersistenceContext
    private EntityManager entityManager;

    public FavouriteExercise getFavouriteExerciseByUserId(int userId) {
        TypedQuery<FavouriteExercise> typedQuery = entityManager.createQuery(getFavouriteExerciseByUserId, FavouriteExercise.class);
        typedQuery.setParameter("userId", userId);
        return typedQuery.getSingleResult();
    }
}
