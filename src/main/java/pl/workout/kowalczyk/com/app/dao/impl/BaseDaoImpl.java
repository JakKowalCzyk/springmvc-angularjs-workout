package pl.workout.kowalczyk.com.app.dao.impl;

import org.springframework.stereotype.Repository;
import pl.workout.kowalczyk.com.app.dao.BaseDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by JK on 2016-09-03.
 */
@Repository
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

    private Class<T> entityClass;

    @PersistenceContext
    private EntityManager entityManager;

    public BaseDaoImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    public List<T> getAll() {
        return entityManager
                .createQuery("from " + entityClass.getName(), entityClass)
                .getResultList();
    }

    public void save(T domain) {
        entityManager.persist(domain);
    }


    public void update(T domain) {
        entityManager.merge(domain);
    }

    public void delete(T domain) {
        entityManager.remove(domain);
    }

    public T get(int id) {
        return entityManager.find(entityClass, id);
    }
}
