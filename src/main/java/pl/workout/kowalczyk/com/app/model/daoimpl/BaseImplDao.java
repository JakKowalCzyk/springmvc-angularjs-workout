package pl.workout.kowalczyk.com.app.model.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import pl.workout.kowalczyk.com.app.model.dao.BaseDao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by JK on 2016-09-03.
 */
public abstract class BaseImplDao<T> extends HibernateDaoSupport implements BaseDao<T> {

    private Class<T> entityClass;

    @Autowired
    public void setSession(SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }

    public BaseImplDao() {
        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
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
