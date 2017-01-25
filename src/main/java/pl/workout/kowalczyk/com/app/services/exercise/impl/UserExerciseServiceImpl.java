package pl.workout.kowalczyk.com.app.services.exercise.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.workout.kowalczyk.com.app.dao.exercise.UserExerciseDao;
import pl.workout.kowalczyk.com.app.dao.exercise.WorkoutDao;
import pl.workout.kowalczyk.com.app.model.BO.exercise.UserExercise;
import pl.workout.kowalczyk.com.app.model.DTO.exercise.UserExerciseDTO;
import pl.workout.kowalczyk.com.app.services.exercise.ExerciseService;
import pl.workout.kowalczyk.com.app.services.exercise.UserExerciseService;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by JK on 2016-10-26.
 */
@Service
public class UserExerciseServiceImpl implements UserExerciseService {
    @Autowired
    private UserExerciseDao userExerciseDao;
    @Autowired
    private WorkoutDao workoutDao;
    @Autowired
    private ExerciseService exerciseService;

    @Override
    public UserExercise mapUserExerciseDtoToBo(UserExerciseDTO userExerciseDTO) {
        UserExercise userExercise = new UserExercise(userExerciseDTO.getRepeat(), userExerciseDTO.getSeries());
        userExercise.setExercise(exerciseService.getExerciseById(userExerciseDTO.getExerciseId()));
        userExercise.setWorkoutId(workoutDao.findOne(userExerciseDTO.getWorkoutId()));
        return userExercise;
    }

    @Override
    public UserExerciseDTO mapUserExerciseBoToDto(UserExercise userExercise) {
        return new UserExerciseDTO(userExercise.getId(), userExercise.getWorkoutId().getId(), userExercise.getRepeat(), userExercise.getSeries(), userExercise.getExercise().getId());
    }

    @Override
    public void saveUserExercise(UserExerciseDTO userExerciseDTO) {
        userExerciseDao.save(mapUserExerciseDtoToBo(userExerciseDTO));
    }

    @Override
    public void updateUserExerciseWithRepeatAndSeries(UserExerciseDTO userExerciseDTO) {
        userExerciseDao.updateUserExerciseWithRepeatAndSeries(userExerciseDTO.getId(), userExerciseDTO.getRepeat(), userExerciseDTO.getSeries());
    }

    @Override
    public void deleteUserExercise(Integer userExerciseId) {
        userExerciseDao.delete(userExerciseId);
    }

    @Override
    public List<UserExerciseDTO> getUserExercisesByWorkoutDate(int userId, Date date) {
        return workoutDao.getUserExercisesByIdAndDate(userId, date).stream().map(this::mapUserExerciseBoToDto).collect(Collectors.toList());
    }

    @Override
    public List<UserExerciseDTO> getUserExercisesByUserId(int userId) {
        return userExerciseDao.getUserExercisesByUserId(userId).stream().map(this::mapUserExerciseBoToDto).collect(Collectors.toList());
    }

    @Override
    public List<UserExerciseDTO> getUserExercisesBoWorkout(Integer workoutId) {
        return workoutDao.findOne(workoutId).getUserExercises().stream().map(this::mapUserExerciseBoToDto).collect(Collectors.toList());
    }
}
