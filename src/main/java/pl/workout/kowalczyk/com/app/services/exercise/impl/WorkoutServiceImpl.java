package pl.workout.kowalczyk.com.app.services.exercise.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.workout.kowalczyk.com.app.dao.security.UserDetailsDao;
import pl.workout.kowalczyk.com.app.dao.exercise.WorkoutDao;
import pl.workout.kowalczyk.com.app.model.BO.exercise.Workout;
import pl.workout.kowalczyk.com.app.model.DTO.exercise.WorkoutDTO;
import pl.workout.kowalczyk.com.app.services.exercise.WorkoutService;

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
    private UserDetailsDao userDetailsDao;


    @Override
    public Workout mapWorkoutDtoToBo(WorkoutDTO workoutDTO) {
        return new Workout(userDetailsDao.get(workoutDTO.getUser_id()), workoutDTO.getDate());
    }

    @Override
    public WorkoutDTO mapWorkoutBoToDto(Workout workout) {
        return new WorkoutDTO(workout.getWorkout_id(), workout.getUser_id().getUserId(), workout.getDate());
    }

    public void saveWorkout(WorkoutDTO workoutDTO) {
        workoutDao.save(mapWorkoutDtoToBo(workoutDTO));
    }

    public void updateWorkout(WorkoutDTO workoutDTO) {
        Workout workout = mapWorkoutDtoToBo(workoutDTO);
        workout.setWorkout_id(workoutDTO.getWorkout_id());
        workoutDao.update(workout);
    }

    public void deleteWorkout(Integer workoutId) {
        Workout workout = workoutDao.get(workoutId);
        workoutDao.delete(workout);
    }

    public List<WorkoutDTO> getWorkoutsByUserId(int userId) {
        return workoutDao.getWorkoutsByUserId(userId).stream().map(this::mapWorkoutBoToDto).collect(Collectors.toList());
    }

    public WorkoutDTO getByUserIdAndDate(int userId, Date date) {
        return mapWorkoutBoToDto(workoutDao.getByUserIdAndDate(userId, date));
    }
}
