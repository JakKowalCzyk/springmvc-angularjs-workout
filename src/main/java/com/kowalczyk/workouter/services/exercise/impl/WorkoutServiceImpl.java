package com.kowalczyk.workouter.services.exercise.impl;

import com.kowalczyk.workouter.dao.exercise.WorkoutDao;
import com.kowalczyk.workouter.model.BO.exercise.Workout;
import com.kowalczyk.workouter.services.exercise.WorkoutService;
import com.kowalczyk.workouter.services.impl.ModelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
@Service
public class WorkoutServiceImpl extends ModelServiceImpl<Workout> implements WorkoutService {


    @Autowired
    public WorkoutServiceImpl(WorkoutDao baseDao) {
        super(baseDao);
    }

    @Override
    public List<Workout> getWorkoutsByUserId(Long userId) {
        return ((WorkoutDao) getBaseDao()).getWorkoutsByUserId(userId);
    }

    @Override
    public Workout getByUserIdAndDate(Long userId, Date date) {
        return ((WorkoutDao) getBaseDao()).getByUserIdAndDate(userId, date);
    }

    @Override
    public void deleteObject(Long id) {
        removeWorkoutFromUser(id);
        super.deleteObject(id);
    }

    private void removeWorkoutFromUser(Long id) {
        Workout workoutToDelete = super.getObject(id);
        workoutToDelete.getUser().getWorkouts().remove(workoutToDelete);
    }
}
