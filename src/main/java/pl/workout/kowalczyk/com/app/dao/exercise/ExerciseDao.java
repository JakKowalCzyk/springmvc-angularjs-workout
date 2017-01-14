package pl.workout.kowalczyk.com.app.dao.exercise;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.workout.kowalczyk.com.app.dao.BaseDao;
import pl.workout.kowalczyk.com.app.enums.ExerciseType;
import pl.workout.kowalczyk.com.app.model.BO.exercise.Exercise;

import java.util.List;

/**
 * Created by JK on 2016-09-22.
 */
public interface ExerciseDao extends BaseDao<Exercise> {

    @Query("SELECT o FROM Exercise o where o.name = :name")
    Exercise getExerciseByName(@Param("name") String name);

    @Query("SELECT o FROM Exercise o where o.exerciseType = :exerciseType")
    List<Exercise> getExercisesForBodyPart(@Param("exerciseType") ExerciseType exerciseType);
}
