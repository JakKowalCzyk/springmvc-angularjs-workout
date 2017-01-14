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
        setExerciseDtoToBo(userExerciseDTO, userExercise);
        userExercise.setWorkout_id(workoutDao.findOne(userExerciseDTO.getWorkout_id()));
        return userExercise;
    }

    private void setExerciseDtoToBo(UserExerciseDTO userExerciseDTO, UserExercise userExercise) {
        if (userExerciseDTO.getExerciseId() == null) {
            userExercise.setExercise(exerciseService.mapExerciseDtoToBo(userExerciseDTO.getExercise()));
        }else{
            userExercise.setExercise(exerciseService.getExerciseById(userExerciseDTO.getExerciseId()));
        }
    }

    @Override
    public UserExerciseDTO mapUserExerciseBoToDto(UserExercise userExercise) {
        return new UserExerciseDTO(userExercise.getId(), exerciseService.mapExerciseBoToDTO(userExercise.getExercise()), userExercise.getWorkout_id().getId(), userExercise.getRepeat(), userExercise.getSeries());
    }

    public void saveUserExercise(UserExerciseDTO userExerciseDTO) {
        userExerciseDao.save(mapUserExerciseDtoToBo(userExerciseDTO));
    }

    public void updateUserExercise(UserExerciseDTO userExerciseDTO) {
        UserExercise userExercise = mapUserExerciseDtoToBo(userExerciseDTO);
        userExercise.setId(userExerciseDTO.getId());
//        userExerciseDao.update(userExercise);
    }

    public void deleteUserExercise(Integer userExerciseId) {
        UserExercise userExercise = userExerciseDao.findOne(userExerciseId);
        userExerciseDao.delete(userExercise);
    }

    public List<UserExerciseDTO> getUserExercisesByWorkout(int userId, Date date) {
        return workoutDao.getUserExercisesByIdAndDate(userId, date).stream().map(this::mapUserExerciseBoToDto).collect(Collectors.toList());
    }

    public List<UserExerciseDTO> getUserExercisesByUserId(int userId) {
        return userExerciseDao.getUserExercisesByUserId(userId).stream().map(this::mapUserExerciseBoToDto).collect(Collectors.toList());
    }
}
