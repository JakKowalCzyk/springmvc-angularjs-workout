package pl.workout.kowalczyk.com.app.services.serviceImpl;

import com.sun.xml.internal.ws.developer.Serialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.workout.kowalczyk.com.app.model.data.model.dao.UserExerciseDao;
import pl.workout.kowalczyk.com.app.model.data.model.dao.WorkoutDao;
import pl.workout.kowalczyk.com.app.model.data.model.entity.UserExercise;
import pl.workout.kowalczyk.com.app.services.service.UserExerciseService;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
@Service
@Transactional
public class UserExerciseServiceImpl implements UserExerciseService {
    @Autowired
    private UserExerciseDao userExerciseDao;
    @Autowired
    private WorkoutDao workoutDao;

    public void saveUserExercise(UserExercise userExercise) {
        userExerciseDao.save(userExercise);
    }

    public void updateUserExercise(UserExercise userExercise) {
        userExerciseDao.update(userExercise);
    }

    public void deleteUserExercise(UserExercise userExercise) {
        userExerciseDao.delete(userExercise);
    }

    public List<UserExercise> getUserExercisesByWorkout(int userId, Date date) {
        return workoutDao.getUserExercisesByIdAndDate(userId, date);
    }

    public List<UserExercise> getUserExercisesByUserId(int userId) {
        return userExerciseDao.getUserExercisesByUserId(userId);
    }
}
