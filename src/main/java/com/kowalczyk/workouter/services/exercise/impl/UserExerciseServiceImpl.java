package com.kowalczyk.workouter.services.exercise.impl;

import com.kowalczyk.workouter.dao.exercise.UserExerciseDao;
import com.kowalczyk.workouter.model.BO.exercise.UserExercise;
import com.kowalczyk.workouter.services.exercise.UserExerciseService;
import com.kowalczyk.workouter.services.impl.ModelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
