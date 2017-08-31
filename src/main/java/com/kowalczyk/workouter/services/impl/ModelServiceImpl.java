package com.kowalczyk.workouter.services.impl;

import com.kowalczyk.workouter.dao.BaseDAO;
import com.kowalczyk.workouter.model.BO.ModelObject;
import com.kowalczyk.workouter.services.ModelService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by JK on 2017-02-18.
 */
@Service
public abstract class ModelServiceImpl<T extends ModelObject> implements ModelService<T> {

    private BaseDAO<T> baseDAO;

    public ModelServiceImpl(BaseDAO<T> baseDAO) {
        super();
        this.baseDAO = baseDAO;
    }

    @Override
    public T getObject(Long id) {
        return baseDAO.findOne(id);
    }

    @Override
    public T addObject(T baseModel) {
        return baseDAO.save(baseModel);
    }

    @Override
    public T updateObject(T baseModel) {
        return baseDAO.save(baseModel);
    }

    @Override
    public void deleteObject(Long id) {
        baseDAO.delete(id);
    }

    @Override
    public void deleteObject(T baseModel) {
        baseDAO.delete(baseModel);
    }

    @Override
    public List<T> getAll() {
        return baseDAO.findAll();
    }

    @Override
    public boolean isExist(Long id) {
        return baseDAO.exists(id);
    }

    protected BaseDAO<T> getBaseDAO() {
        return baseDAO;
    }
}
