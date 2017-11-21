package com.kowalczyk.workouter.model.BO;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by JK on 2017-01-14.
 */
@MappedSuperclass
public abstract class ModelObject {

    private Long id;

    public ModelObject() {
    }

    public ModelObject(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
