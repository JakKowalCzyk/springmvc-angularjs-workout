package com.kowalczyk.workouter.model.DTO.security;

import com.kowalczyk.workouter.model.DTO.ObjectDTO;

/**
 * Created by JK on 2018-01-15.
 */
public class ResetPasswordObject extends ObjectDTO {

    private String token;
    private String newPassword;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
