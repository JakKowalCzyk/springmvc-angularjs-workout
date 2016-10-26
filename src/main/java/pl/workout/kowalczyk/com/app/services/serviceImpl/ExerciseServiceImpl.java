package pl.workout.kowalczyk.com.app.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.workout.kowalczyk.com.app.enums.ExerciseType;
import pl.workout.kowalczyk.com.app.model.data.dao.ExerciseDao;
import pl.workout.kowalczyk.com.app.model.data.entity.Exercise;
import pl.workout.kowalczyk.com.app.services.service.ExerciseService;

import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
@Service
@Transactional
public class ExerciseServiceImpl implements ExerciseService {
    @Autowired
    private ExerciseDao exerciseDao;

    public void saveExercise(Exercise exercise) {
        exerciseDao.save(exercise);
    }

    public void getAllExercises() {
        exerciseDao.getAll();
    }

    public Exercise getExerciseByName(String name) {
        return exerciseDao.getExerciseByName(name);
    }

    public List<Exercise> getExercisesForBodyPart(ExerciseType exerciseType) {
        return exerciseDao.getExercisesForBodyPart(exerciseType);
    }
}
