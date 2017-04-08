package com.kowalczyk.workouter.model.DTO.user;

import com.kowalczyk.workouter.model.DTO.ObjectDTO;

/**
 * Created by JK on 2017-04-07.
 */
public class AbstractUserObjectDTO extends ObjectDTO {

    private Long userId;

    public AbstractUserObjectDTO() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
