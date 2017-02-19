package pl.workout.kowalczyk.com.app.services;

import pl.workout.kowalczyk.com.app.model.BO.ModelObject;

import java.util.List;

/**
 * Created by JK on 2017-02-18.
 */
public interface ModelService<T extends ModelObject> {

    T getObject(Long id);

    T addObject(T baseModel);

    T updateObject(T baseModel);

    void deleteObject(Long id);

    List<T> getAll();
}
