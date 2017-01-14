package pl.workout.kowalczyk.com.app.model.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by JK on 2016-11-09.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class BaseModel {
    private Integer id;

    public BaseModel() {
    }

    public BaseModel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
