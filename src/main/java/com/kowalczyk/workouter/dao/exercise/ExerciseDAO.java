package com.kowalczyk.workouter.dao.exercise;

import com.kowalczyk.workouter.dao.BaseDAO;
import com.kowalczyk.workouter.enums.ExerciseType;
import com.kowalczyk.workouter.model.BO.exercise.Exercise;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by JK on 2016-09-22.
 */
public interface ExerciseDAO extends BaseDAO<Exercise> {

    @Query("SELECT o FROM Exercise o where o.exerciseType = :exerciseType")
    List<Exercise> getExercisesForBodyPart(@Param("exerciseType") ExerciseType exerciseType);

    @Query("select o from Exercise o where lower(o.name) LIKE CONCAT('%',:tag,'%') or lower(o.description) like CONCAT('%',:tag,'%') " +
            "or lower(o.exerciseType) like CONCAT('%',:tag,'%')")
    List<Exercise> findByNameContainingIgnoreCase(@Param("tag") String tag);
}
