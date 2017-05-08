package com.kowalczyk.workouter.services;

import com.kowalczyk.workouter.model.BO.ModelObject;

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

    boolean isExist(Long id);
}
