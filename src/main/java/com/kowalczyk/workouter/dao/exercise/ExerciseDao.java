package com.kowalczyk.workouter.dao.exercise;

import com.kowalczyk.workouter.dao.BaseDao;
import com.kowalczyk.workouter.enums.ExerciseType;
import com.kowalczyk.workouter.model.BO.exercise.Exercise;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by JK on 2016-09-22.
 */
public interface ExerciseDao extends BaseDao<Exercise> {

    @Query("SELECT o FROM Exercise o where o.exerciseType = :exerciseType")
    List<Exercise> getExercisesForBodyPart(@Param("exerciseType") ExerciseType exerciseType);

    List<Exercise> findByNameContainingOrDescriptionContainingOrExerciseTypeContaining(String tag);
}
