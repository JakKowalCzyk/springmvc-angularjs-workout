package com.kowalczyk.workouter.services.exercise.impl;

import com.kowalczyk.workouter.dao.exercise.WorkoutExerciseDAO;
import com.kowalczyk.workouter.model.BO.exercise.WorkoutExercise;
import com.kowalczyk.workouter.services.exercise.WorkoutExerciseService;
import com.kowalczyk.workouter.services.impl.ModelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
@Service
public class WorkoutExerciseServiceImpl extends ModelServiceImpl<WorkoutExercise> implements WorkoutExerciseService {

    @Autowired
    public WorkoutExerciseServiceImpl(WorkoutExerciseDAO baseDao) {
        super(baseDao);
    }

    @Override
    public List<WorkoutExercise> getWorkoutExercisesByUserId(Long userId) {
        return ((WorkoutExerciseDAO) getBaseDao()).getUserExercisesByUserId(userId);
    }

    @Override
    public List<WorkoutExercise> findByWorkoutId(Long workoutId) {
        return ((WorkoutExerciseDAO) getBaseDao()).findByWorkoutId(workoutId);
    }

    @Override
    public void deleteObject(Long id) {
        removeWorkoutExerciseFromWorkout(id);
        super.deleteObject(id);
    }

    private void removeWorkoutExerciseFromWorkout(Long id) {
        WorkoutExercise workoutExerciseToDelete = super.getObject(id);
        workoutExerciseToDelete.getWorkout().getWorkoutExercises().remove(workoutExerciseToDelete);
    }

    @Override
    public WorkoutExercise updateObject(WorkoutExercise baseModel) {
        baseModel.setWorkout(super.getObject(baseModel.getId()).getWorkout());
        return super.updateObject(baseModel);
    }
}
