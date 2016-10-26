package pl.workout.kowalczyk.com.app.services.serviceImpl;

import com.sun.xml.internal.ws.developer.Serialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.workout.kowalczyk.com.app.model.data.model.dao.WorkoutDao;
import pl.workout.kowalczyk.com.app.model.data.model.entity.Workout;
import pl.workout.kowalczyk.com.app.services.service.WorkoutService;

import java.sql.Date;
import java.util.List;

/**
 * Created by JK on 2016-10-26.
 */
@Service
@Transactional
public class WorkoutServiceImpl implements WorkoutService {
    @Autowired
    private WorkoutDao workoutDao;

    public void saveWorkout(Workout workout) {
        workoutDao.save(workout);
    }

    public void updateWorkout(Workout workout) {
        workoutDao.update(workout);
    }

    public void deleteWorkout(Workout workout) {
        workoutDao.delete(workout);
    }

    public List<Workout> getWorkoutsByUserId(int userId) {
        return workoutDao.getWorkoutsByUserId(userId);
    }

    public Workout getByUserIdAndDate(int userId, Date date) {
        return workoutDao.getByUserIdAndDate(userId, date);
    }
}
