package com.kowalczyk.workouter.services.impl;

import com.kowalczyk.workouter.dao.BaseDao;
import com.kowalczyk.workouter.model.BO.ModelObject;
import com.kowalczyk.workouter.services.ModelService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by JK on 2017-02-18.
 */
@Service
public abstract class ModelServiceImpl<T extends ModelObject> implements ModelService<T> {

    private BaseDao<T> baseDao;

    public ModelServiceImpl(BaseDao<T> baseDao) {
        super();
        this.baseDao = baseDao;
    }

    @Override
    public T getObject(Long id) {
        return baseDao.findOne(id);
    }

    @Override
    public T addObject(T baseModel) {
        return baseDao.save(baseModel);
    }

    @Override
    public T updateObject(T baseModel) {
        return baseDao.save(baseModel);
    }

    @Override
    public void deleteObject(Long id) {
        baseDao.delete(id);
    }

    @Override
    public void deleteObject(T baseModel) {
        baseDao.delete(baseModel);
    }

    @Override
    public List<T> getAll() {
        return baseDao.findAll();
    }

    @Override
    public boolean isExist(Long id) {
        return baseDao.exists(id);
    }

    protected BaseDao<T> getBaseDao() {
        return baseDao;
    }
}
