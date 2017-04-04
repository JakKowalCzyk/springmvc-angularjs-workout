//package pl.workout.kowalczyk.com.app.configuration.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.oauth2.provider.ClientDetailsService;
//import org.springframework.security.oauth2.provider.approval.ApprovalStore;
//import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
//import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
//import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
//import pl.workout.kowalczyk.com.app.services.user.security.UserDetailsService;
//
//import javax.sql.DataSource;
//
///**
// * Created by JK on 2016-11-28.
// */
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class OAuth2SecurityConfiguration extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private ClientDetailsService clientDetailsService;
//    @Autowired
//    private UserDetailsService userDetailsService;
//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    public void globalUserDetails(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        authenticationManagerBuilder.userDetailsService(userDetailsService);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .anonymous().disable()
//                .authorizeRequests()
//                .antMatchers("/oauth/token").permitAll();
//    }
//
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Bean
//    public TokenStore tokenStore() {
//        return new JdbcTokenStore(dataSource);
//    }
//
//    @Bean
//    @Autowired
//    public TokenStoreUserApprovalHandler tokenStoreUserApprovalHandler(TokenStore tokenStore) {
//        TokenStoreUserApprovalHandler tokenStoreUserApprovalHandler = new TokenStoreUserApprovalHandler();
//        tokenStoreUserApprovalHandler.setTokenStore(tokenStore);
//        tokenStoreUserApprovalHandler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
//        tokenStoreUserApprovalHandler.setClientDetailsService(clientDetailsService);
//        return tokenStoreUserApprovalHandler;
//    }
//
//    @Bean
//    @Autowired
//    public ApprovalStore approvalStore(TokenStore tokenStore) {
//        TokenApprovalStore tokenApprovalStore = new TokenApprovalStore();
//        tokenApprovalStore.setTokenStore(tokenStore);
//        return tokenApprovalStore;
//    }
//
//
//}
