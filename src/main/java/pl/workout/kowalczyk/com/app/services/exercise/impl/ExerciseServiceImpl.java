package pl.workout.kowalczyk.com.app.services.exercise.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.workout.kowalczyk.com.app.dao.exercise.ExerciseDao;
import pl.workout.kowalczyk.com.app.enums.ExerciseType;
import pl.workout.kowalczyk.com.app.model.BO.exercise.Exercise;
import pl.workout.kowalczyk.com.app.services.exercise.ExerciseService;
import pl.workout.kowalczyk.com.app.services.impl.ModelServiceImpl;

import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
@Service
public class ExerciseServiceImpl extends ModelServiceImpl<Exercise> implements ExerciseService {

    @Autowired
    public ExerciseServiceImpl(ExerciseDao baseDao) {
        super(baseDao);
    }

    public Exercise getExerciseByName(String name) {
        return ((ExerciseDao) getBaseDao()).getExerciseByName(name);
    }

    public List<Exercise> getExercisesForBodyPart(ExerciseType exerciseType) {
        return ((ExerciseDao) getBaseDao()).getExercisesForBodyPart(exerciseType);
    }
}
