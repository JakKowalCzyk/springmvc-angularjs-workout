package pl.workout.kowalczyk.com.app.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.workout.kowalczyk.com.app.enums.ExerciseType;
import pl.workout.kowalczyk.com.app.dao.ExerciseDao;
import pl.workout.kowalczyk.com.app.model.BO.Exercise;
import pl.workout.kowalczyk.com.app.model.DTO.ExerciseDTO;
import pl.workout.kowalczyk.com.app.services.service.ExerciseService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by JK on 2016-10-26.
 */
@Service
@Transactional
public class ExerciseServiceImpl implements ExerciseService {
    @Autowired
    private ExerciseDao exerciseDao;
    @Override
    public ExerciseDTO mapExerciseBoToDTO(Exercise exercise) {
        return new ExerciseDTO(exercise.getExercise_id(), exercise.getName(), exercise.getDescription(), exercise.getExerciseType());
    }

    @Override
    public Exercise mapExerciseDtoToBo(ExerciseDTO exerciseDTO) {
        return new Exercise(exerciseDTO.getExercise_id(), exerciseDTO.getName(), exerciseDTO.getDescription(), exerciseDTO.getExerciseType());
    }

    public void saveExercise(ExerciseDTO exerciseDTO) {
        exerciseDao.save(mapExerciseDtoToBo(exerciseDTO));
    }

    public List<ExerciseDTO> getAllExercisesDTO() {
        return exerciseDao.getAll().stream().map(this::mapExerciseBoToDTO).collect(Collectors.toList());
    }

    public ExerciseDTO getExerciseDTOByName(String name) {
        return mapExerciseBoToDTO(exerciseDao.getExerciseByName(name));
    }

    @Override
    public ExerciseDTO getExerciseDTOById(int exerciseId) {
       return mapExerciseBoToDTO(exerciseDao.get(exerciseId));
    }

    @Override
    public Exercise getExerciseById(int exerciseId) {
        return exerciseDao.get(exerciseId);
    }

    public List<ExerciseDTO> getExercisesDTOForBodyPart(ExerciseType exerciseType) {
        return exerciseDao.getExercisesForBodyPart(exerciseType).stream().map(this::mapExerciseBoToDTO).collect(Collectors.toList());
    }
}
