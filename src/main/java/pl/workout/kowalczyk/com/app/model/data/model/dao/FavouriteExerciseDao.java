package pl.workout.kowalczyk.com.app.model.data.model.dao;

import pl.workout.kowalczyk.com.app.model.data.model.entity.FavouriteExercise;

/**
 * Created by JK on 2016-09-22.
 */
public interface FavouriteExerciseDao extends BaseDao<FavouriteExercise> {
    FavouriteExercise getFavouriteExerciseByUserId(int userId);

}
