package pl.workout.kowalczyk.com.app.model.daoimpl;

import org.hibernate.usertype.ParameterizedType;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import pl.workout.kowalczyk.com.app.model.dao.DaoBase;

import java.util.List;

/**
 * Created by JK on 2016-09-03.
 */
public class DaoBaseImpl<T> extends HibernateDaoSupport implements DaoBase<T> {

    private Class<T> entityClass;

    public DaoBaseImpl() {
        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        entityClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];

    }

    public List<T> getAll() {
        return getHibernateTemplate().loadAll()
    }

    public void save(T domain) {

    }

    public void update(T domain) {

    }

    public void delete(T domain) {

    }

    public T get(Long id) {
        return null;
    }
}
