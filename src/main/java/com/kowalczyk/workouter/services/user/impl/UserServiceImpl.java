package com.kowalczyk.workouter.services.user.impl;

import com.kowalczyk.workouter.dao.user.UserDAO;
import com.kowalczyk.workouter.model.BO.security.Role;
import com.kowalczyk.workouter.model.BO.user.User;
import com.kowalczyk.workouter.model.BO.user.impl.UserInfo;
import com.kowalczyk.workouter.services.impl.ModelServiceImpl;
import com.kowalczyk.workouter.services.user.UserInfoService;
import com.kowalczyk.workouter.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by JK on 2016-12-18.
 */
@Service
public class UserServiceImpl extends ModelServiceImpl<User> implements UserService {

    private UserInfoService userInfoService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private TokenStore tokenStore;

    @Autowired
    public UserServiceImpl(UserDAO baseDao, UserInfoService userInfoService, BCryptPasswordEncoder bCryptPasswordEncoder, TokenStore tokenStore) {
        super(baseDao);
        this.userInfoService = userInfoService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.tokenStore = tokenStore;
    }

    @Override
    public User addObject(User baseModel) {
        hashUserPassword(baseModel);
        User user = super.addObject(baseModel);
        createNewUserInfo(user);
        return user;
    }

    @Override
    public User updateObject(User baseModel) {
        baseModel.setHashedPassword(super.getObject(baseModel.getId()).getHashedPassword());
        return super.updateObject(baseModel);
    }

    private void hashUserPassword(User baseModel) {
        baseModel.setHashedPassword(bCryptPasswordEncoder.encode(baseModel.getHashedPassword()));
    }

    private void createNewUserInfo(User user) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUser(user);
        userInfoService.addObject(userInfo);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = getByLogin(s);
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getHashedPassword(), user.isEnabled(), user.isAccountNonExpired(), user.isCredentialsNonExpired(),
                user.isAccountNonLocked(), buildUserAuthority(user.getRoles()));
    }

    private List<GrantedAuthority> buildUserAuthority(Set<Role> userRoles) {
        return userRoles.stream().map(userRole -> new SimpleGrantedAuthority(userRole.getRoleType().name())).collect(Collectors.toList());
    }

    @Override
    public User getByLogin(String login) {
        return ((UserDAO) getBaseDAO()).findByLogin(login);
    }

    @Override
    public void revokeToken(String token) {
        tokenStore.removeAccessToken(tokenStore.readAccessToken(token));
    }

    @Override
    public void deleteObject(Long id) {
        User user = super.getObject(id);
        deleteUserInfoBeforeUserIfNotNull(user);
        super.deleteObject(id);
    }

    private void deleteUserInfoBeforeUserIfNotNull(User user) {
        if (user.getUserInfo() != null) {
            userInfoService.deleteObject(user.getUserInfo());
        }
    }
}
