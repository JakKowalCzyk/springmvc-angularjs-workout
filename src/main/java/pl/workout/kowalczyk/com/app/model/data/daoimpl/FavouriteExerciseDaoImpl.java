package pl.workout.kowalczyk.com.app.model.data.daoimpl;

import org.springframework.stereotype.Repository;
import pl.workout.kowalczyk.com.app.model.data.dao.FavouriteExerciseDao;
import pl.workout.kowalczyk.com.app.model.data.entity.FavouriteExercise;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by JK on 2016-10-10.
 */
@Repository
public class FavouriteExerciseDaoImpl extends BaseDaoImpl<FavouriteExercise> implements FavouriteExerciseDao {

    @PersistenceContext
    private EntityManager entityManager;


}
