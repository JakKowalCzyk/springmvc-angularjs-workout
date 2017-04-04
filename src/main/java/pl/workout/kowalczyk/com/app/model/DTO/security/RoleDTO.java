package pl.workout.kowalczyk.com.app.model.DTO.security;

import pl.workout.kowalczyk.com.app.model.DTO.ObjectDTO;

/**
 * Created by JK on 2017-04-04.
 */
public class RoleDTO extends ObjectDTO {
    private String name;

    public RoleDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
