package pl.workout.kowalczyk.com.app.services.exercise.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.workout.kowalczyk.com.app.dao.exercise.WorkoutDao;
import pl.workout.kowalczyk.com.app.model.BO.exercise.Workout;
import pl.workout.kowalczyk.com.app.services.exercise.WorkoutService;
import pl.workout.kowalczyk.com.app.services.impl.ModelServiceImpl;

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
}
