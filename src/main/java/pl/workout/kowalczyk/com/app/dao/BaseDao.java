package pl.workout.kowalczyk.com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.workout.kowalczyk.com.app.model.BO.AbstractModel;

/**
 * Created by JK on 2016-09-03.
 */
public interface BaseDao<T extends AbstractModel> extends JpaRepository<T, Integer> {

}
