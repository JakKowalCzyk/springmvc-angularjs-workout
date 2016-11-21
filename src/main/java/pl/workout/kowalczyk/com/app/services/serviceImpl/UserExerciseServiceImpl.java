package pl.workout.kowalczyk.com.app.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.workout.kowalczyk.com.app.dao.UserExerciseDao;
import pl.workout.kowalczyk.com.app.dao.WorkoutDao;
import pl.workout.kowalczyk.com.app.model.BO.UserExercise;
import pl.workout.kowalczyk.com.app.model.DTO.UserExerciseDTO;
import pl.workout.kowalczyk.com.app.services.service.ExerciseService;
import pl.workout.kowalczyk.com.app.services.service.UserExerciseService;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    private ExerciseService exerciseService;

    @Override
    public UserExercise mapUserExerciseDtoToBo(UserExerciseDTO userExerciseDTO) {
        UserExercise userExercise = new UserExercise(userExerciseDTO.getRepeat(), userExerciseDTO.getSeries());
        setExerciseDtoToBo(userExerciseDTO, userExercise);
        userExercise.setWorkout_id(workoutDao.get(userExerciseDTO.getWorkout_id()));
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
        return new UserExerciseDTO(userExercise.getUserExercise_id(), exerciseService.mapExerciseBoToDTO(userExercise.getExercise()), userExercise.getWorkout_id().getWorkout_id(), userExercise.getRepeat(), userExercise.getSeries());
    }

    public void saveUserExercise(UserExerciseDTO userExerciseDTO) {
        userExerciseDao.save(mapUserExerciseDtoToBo(userExerciseDTO));
    }

    public void updateUserExercise(UserExerciseDTO userExerciseDTO) {
        userExerciseDao.update(mapUserExerciseDtoToBo(userExerciseDTO));
    }

    public void deleteUserExercise(Integer userExerciseId) {
        UserExercise userExercise = userExerciseDao.get(userExerciseId);
        userExerciseDao.delete(userExercise);
    }

    public List<UserExerciseDTO> getUserExercisesByWorkout(int userId, Date date) {
        return workoutDao.getUserExercisesByIdAndDate(userId, date).stream().map(this::mapUserExerciseBoToDto).collect(Collectors.toList());
    }

    public List<UserExerciseDTO> getUserExercisesByUserId(int userId) {
        return userExerciseDao.getUserExercisesByUserId(userId).stream().map(this::mapUserExerciseBoToDto).collect(Collectors.toList());
    }
}
