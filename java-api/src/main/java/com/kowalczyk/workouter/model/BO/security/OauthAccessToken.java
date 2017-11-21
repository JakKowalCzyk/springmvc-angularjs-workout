package com.kowalczyk.workouter.model.BO.security;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by JKowalczyk on 2017-08-31.
 */
@Entity(name = "oauth_access_token")
public class OauthAccessToken {

    private String token_id;
    private Byte[] token;
    private String authentication_id;
    private String user_name;
    private String client_id;
    private Byte[] authentication;
    private String refresh_token;

    public OauthAccessToken() {
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

    public String getAuthentication_id() {
        return authentication_id;
    }

    public void setAuthentication_id(String authentication_id) {
        this.authentication_id = authentication_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public Byte[] getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Byte[] authentication) {
        this.authentication = authentication;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }
}
