package pl.workout.kowalczyk.com.app.controllers.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.workout.kowalczyk.com.app.controllers.impl.ModelControllerImpl;
import pl.workout.kowalczyk.com.app.controllers.user.UserWeightController;
import pl.workout.kowalczyk.com.app.mapper.user.impl.UserWeightMapper;
import pl.workout.kowalczyk.com.app.model.BO.user.impl.UserWeight;
import pl.workout.kowalczyk.com.app.model.DTO.user.impl.UserWeightDTO;
import pl.workout.kowalczyk.com.app.services.user.UserWeightService;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by JK on 2017-01-22.
 */
@RestController
public class UserWeightControllerImpl extends ModelControllerImpl<UserWeight, UserWeightDTO> implements UserWeightController {

    @Autowired
    public UserWeightControllerImpl(UserWeightService modelService, UserWeightMapper modelMapper) {
        super(modelService, modelMapper);
    }

    @Override
    public UserWeightDTO getObject(@PathVariable Long id) {
        return super.getObject(id);
    }

    @Override
    public UserWeightDTO updateObject(@RequestBody UserWeightDTO model) {
        return super.updateObject(model);
    }

    @Override
    public UserWeightDTO addObject(@RequestBody UserWeightDTO model) {
        return super.addObject(model);
    }

    @Override
    public List<UserWeightDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteObject(@PathVariable Long id) {
        super.deleteObject(id);
    }

    @Override
    public List<UserWeightDTO> getWeightByUserId(@PathVariable Long id) {
        return ((UserWeightService) getModelService()).getWeightByUserId(id).stream().map(userWeight -> getModelMapper().mapToDTO(userWeight)).collect(Collectors.toList());
    }

    @Override
    public UserWeightDTO getWeightByDate(@PathVariable Long id, @PathVariable Date date) {
        return getModelMapper().mapToDTO(((UserWeightService) getModelService()).getByUserIdAndDate(id, date));
    }

    @Override
    public UserWeightDTO getActualWeight(@PathVariable Long id) {
        return getModelMapper().mapToDTO(((UserWeightService) getModelService()).getActualWeight(id));
    }
}
