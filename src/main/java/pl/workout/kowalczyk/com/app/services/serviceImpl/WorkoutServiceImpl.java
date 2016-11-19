package pl.workout.kowalczyk.com.app.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.workout.kowalczyk.com.app.dao.UserDao;
import pl.workout.kowalczyk.com.app.dao.WorkoutDao;
import pl.workout.kowalczyk.com.app.model.BO.UserExercise;
import pl.workout.kowalczyk.com.app.model.BO.Workout;
import pl.workout.kowalczyk.com.app.model.DTO.UserExerciseDTO;
import pl.workout.kowalczyk.com.app.model.DTO.WorkoutDTO;
import pl.workout.kowalczyk.com.app.services.service.UserExerciseService;
import pl.workout.kowalczyk.com.app.services.service.WorkoutService;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by JK on 2016-10-26.
 */
@Service
@Transactional
public class WorkoutServiceImpl implements WorkoutService {
    @Autowired
    private WorkoutDao workoutDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserExerciseService userExerciseService;

    @Override
    public Workout mapWorkoutDtoToBo(WorkoutDTO workoutDTO) {
        List<UserExercise> userExercisesList = workoutDTO.getUserExercises()
                .stream().map(userExerciseDTO -> userExerciseService.mapUserExerciseDtoToBo(userExerciseDTO)).collect(Collectors.toList());
        return new Workout(workoutDTO.getWorkout_id(), userDao.get(workoutDTO.getUser_id()), workoutDTO.getDate(),  userExercisesList);
    }

    @Override
    public WorkoutDTO mapWorkoutBoToDto(Workout workout) {
        List<UserExerciseDTO> userExerciseDTOs = workout.getUserExercises().stream().map(userExercise -> userExerciseService.mapUserExerciseBoToDto(userExercise)).collect(Collectors.toList());
        return new WorkoutDTO(workout.getWorkout_id(), workout.getUser_id().getUser_id(), workout.getDate(), userExerciseDTOs);
    }

    public void saveWorkout(WorkoutDTO workoutDTO) {
        workoutDao.save(mapWorkoutDtoToBo(workoutDTO));
    }

    public void updateWorkout(WorkoutDTO workoutDTO) {
        workoutDao.update(mapWorkoutDtoToBo(workoutDTO));
    }

    public void deleteWorkout(WorkoutDTO workoutDTO) {
        workoutDao.delete(mapWorkoutDtoToBo(workoutDTO));
    }

    public List<WorkoutDTO> getWorkoutsByUserId(int userId) {
        return workoutDao.getWorkoutsByUserId(userId).stream().map(this::mapWorkoutBoToDto).collect(Collectors.toList());
    }

    public WorkoutDTO getByUserIdAndDate(int userId, Date date) {
        return mapWorkoutBoToDto(workoutDao.getByUserIdAndDate(userId, date));
    }
}
