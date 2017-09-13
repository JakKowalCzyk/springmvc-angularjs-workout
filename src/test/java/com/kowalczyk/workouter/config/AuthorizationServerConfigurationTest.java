//package com.kowalczyk.workouter.config;
//
//import com.kowalczyk.workouter.configuration.security.AuthorizationServerConfiguration;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.Profile;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//
///**
// * Created by JKowalczyk on 2017-02-22.
// */
//@Configuration
//@Profile("test")
//@Primary
//@EnableAuthorizationServer
//public class AuthorizationServerConfigurationTest extends AuthorizationServerConfiguration {
//
//    private static final String RESOURCE_ID = "workout_api";
//    private static final String CLIENT_SECRET = "secret";
//    private static final String REALM = "WORKOUT_REALM";
//    private static final String WORKOUT_CLIENT = "workout_client";
//
//    @Value("#{environment.ACCESS_TOKEN}")
//    private String accessTokenValidity = "600";
//    @Value("#{environment.REFRESH_TOKEN}")
//    private String refreshTokenValidity = "900";
//
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
////        security.realm(REALM + "/client").allowFormAuthenticationForClients();
//    }
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory()
//                .withClient(WORKOUT_CLIENT)
//                .resourceIds(RESOURCE_ID)
//                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
//                .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
//                .scopes("read", "write", "trust")
//                .secret(CLIENT_SECRET)
//                .accessTokenValiditySeconds(Integer.valueOf(accessTokenValidity))
//                .refreshTokenValiditySeconds(Integer.valueOf(refreshTokenValidity));
//    }
//
//}
