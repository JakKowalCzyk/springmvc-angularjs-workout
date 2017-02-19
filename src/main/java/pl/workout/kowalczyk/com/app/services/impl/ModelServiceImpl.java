package pl.workout.kowalczyk.com.app.services.impl;

import pl.workout.kowalczyk.com.app.dao.BaseDao;
import pl.workout.kowalczyk.com.app.model.BO.ModelObject;
import pl.workout.kowalczyk.com.app.services.ModelService;

import java.util.List;

/**
 * Created by JK on 2017-02-18.
 */
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
    public List<T> getAll() {
        return baseDao.findAll();
    }

    protected BaseDao<T> getBaseDao() {
        return baseDao;
    }
}
