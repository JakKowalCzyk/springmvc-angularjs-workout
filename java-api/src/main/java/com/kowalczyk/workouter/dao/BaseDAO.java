package com.kowalczyk.workouter.dao;

import com.kowalczyk.workouter.model.BO.ModelObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by JK on 2016-09-03.
 */
@Transactional
public interface BaseDAO<T extends ModelObject> extends JpaRepository<T, Long> {

}
