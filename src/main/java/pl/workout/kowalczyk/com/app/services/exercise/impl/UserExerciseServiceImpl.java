package pl.workout.kowalczyk.com.app.services.exercise.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.workout.kowalczyk.com.app.dao.exercise.UserExerciseDao;
import pl.workout.kowalczyk.com.app.model.BO.exercise.UserExercise;
import pl.workout.kowalczyk.com.app.services.exercise.UserExerciseService;
import pl.workout.kowalczyk.com.app.services.impl.ModelServiceImpl;

import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
@Service
public class UserExerciseServiceImpl extends ModelServiceImpl<UserExercise> implements UserExerciseService {

    @Autowired
    public UserExerciseServiceImpl(UserExerciseDao baseDao) {
        super(baseDao);
    }

    @Override
    public List<UserExercise> getUserExercisesByUserId(Long userId) {
        return ((UserExerciseDao) getBaseDao()).getUserExercisesByUserId(userId);
    }

    @Override
    public List<UserExercise> findByWorkoutId(Long workoutId) {
        return ((UserExerciseDao) getBaseDao()).findByWorkoutId(workoutId);
    }

}
