package com.kowalczyk.workouter.model.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by JK on 2016-11-09.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class ObjectDTO {
    private Long id;

    public ObjectDTO() {
    }

    public ObjectDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
