package pl.workout.kowalczyk.com.app.model.daoimpl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import pl.workout.kowalczyk.com.app.model.dao.DaoBase;

import java.util.List;

/**
 * Created by JK on 2016-09-03.
 */
public class DaoBaseImpl<T> extends HibernateDaoSupport implements DaoBase<T> {

    private Class<T> entityClass;

    public DaoBaseImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public List<T> getAll() {
        return getHibernateTemplate().loadAll(entityClass);
    }

    public void save(T domain) {
        getHibernateTemplate().save(domain);
    }

    public void update(T domain) {
        getHibernateTemplate().update(domain);
    }

    public void delete(T domain) {
        getHibernateTemplate().delete(domain);
    }

    public T get(Long id) {
        T o = (T) getHibernateTemplate().get(entityClass, id);
        return o;
    }
}
