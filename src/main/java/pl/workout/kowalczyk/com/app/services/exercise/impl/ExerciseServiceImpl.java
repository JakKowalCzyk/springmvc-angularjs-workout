package pl.workout.kowalczyk.com.app.services.exercise.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.workout.kowalczyk.com.app.dao.exercise.ExerciseDao;
import pl.workout.kowalczyk.com.app.enums.ExerciseType;
import pl.workout.kowalczyk.com.app.model.BO.exercise.Exercise;
import pl.workout.kowalczyk.com.app.model.DTO.exercise.ExerciseDTO;
import pl.workout.kowalczyk.com.app.services.exercise.ExerciseService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by JK on 2016-10-26.
 */
@Service
public class ExerciseServiceImpl implements ExerciseService {
    @Autowired
    private ExerciseDao exerciseDao;
    @Override
    public ExerciseDTO mapExerciseBoToDTO(Exercise exercise) {
        return new ExerciseDTO(exercise.getId(), exercise.getName(), exercise.getDescription(), exercise.getExerciseType());
    }

    @Override
    public Exercise mapExerciseDtoToBo(ExerciseDTO exerciseDTO) {
        return new Exercise(exerciseDTO.getName(), exerciseDTO.getDescription(), exerciseDTO.getExerciseType());
    }

    public void saveExercise(ExerciseDTO exerciseDTO) {
        exerciseDao.save(mapExerciseDtoToBo(exerciseDTO));
    }

    public List<ExerciseDTO> getAllExercisesDTO() {
        return exerciseDao.findAll().stream().map(this::mapExerciseBoToDTO).collect(Collectors.toList());
    }

    public ExerciseDTO getExerciseDTOByName(String name) {
        return mapExerciseBoToDTO(exerciseDao.getExerciseByName(name));
    }

    @Override
    public ExerciseDTO getExerciseDTOById(int exerciseId) {
       return mapExerciseBoToDTO(exerciseDao.findOne(exerciseId));
    }

    @Override
    public Exercise getExerciseById(int exerciseId) {
        return exerciseDao.findOne(exerciseId);
    }

    public List<ExerciseDTO> getExercisesDTOForBodyPart(ExerciseType exerciseType) {
        return exerciseDao.getExercisesForBodyPart(exerciseType).stream().map(this::mapExerciseBoToDTO).collect(Collectors.toList());
    }
}
