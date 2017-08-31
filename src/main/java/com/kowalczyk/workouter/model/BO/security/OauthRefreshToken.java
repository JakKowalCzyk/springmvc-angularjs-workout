package com.kowalczyk.workouter.model.BO.security;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by JKowalczyk on 2017-08-31.
 */
@Entity(name = "oauth_refresh_token")
public class OauthRefreshToken {

    private String token_id;
    private Byte[] token;
    private Byte[] authentication;

    public OauthRefreshToken() {
    }

    @Id
    public String getToken_id() {
        return token_id;
    }

    public void setToken_id(String token_id) {
        this.token_id = token_id;
    }

    public Byte[] getToken() {
        return token;
    }

    public void setToken(Byte[] token) {
        this.token = token;
    }

    public Byte[] getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Byte[] authentication) {
        this.authentication = authentication;
    }
}
