package pl.workout.kowalczyk.com.app.model.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by JK on 2016-09-03.
 */
public interface DaoBase<T> {

    List<T> getAll();

    void save(T domain);

    void update(T domain);

    void delete(T domain);

    T get(Long id);
}
