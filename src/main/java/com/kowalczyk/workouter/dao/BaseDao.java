package com.kowalczyk.workouter.dao;

import com.kowalczyk.workouter.model.BO.ModelObject;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by JK on 2016-09-03.
 */
public interface BaseDao<T extends ModelObject> extends JpaRepository<T, Long> {

}
