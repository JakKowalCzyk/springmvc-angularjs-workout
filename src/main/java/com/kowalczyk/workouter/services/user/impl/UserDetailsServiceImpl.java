package com.kowalczyk.workouter.services.user.impl;

import com.kowalczyk.workouter.dao.user.UserDetailsDAO;
import com.kowalczyk.workouter.model.BO.security.Role;
import com.kowalczyk.workouter.model.BO.user.impl.UserInfo;
import com.kowalczyk.workouter.services.impl.ModelServiceImpl;
import com.kowalczyk.workouter.services.user.UserDetailsService;
import com.kowalczyk.workouter.services.user.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by JK on 2016-12-18.
 */
@Service
public class UserDetailsServiceImpl extends ModelServiceImpl<com.kowalczyk.workouter.model.BO.user.UserDetails> implements UserDetailsService {

    private UserInfoService userInfoService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserDetailsServiceImpl(UserDetailsDAO baseDao, UserInfoService userInfoService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        super(baseDao);
        this.userInfoService = userInfoService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public com.kowalczyk.workouter.model.BO.user.UserDetails addObject(com.kowalczyk.workouter.model.BO.user.UserDetails baseModel) {
        hashUserPassword(baseModel);
        com.kowalczyk.workouter.model.BO.user.UserDetails userDetails = super.addObject(baseModel);
        createNewUserInfo(userDetails);
        return userDetails;
    }

    @Override
    public com.kowalczyk.workouter.model.BO.user.UserDetails updateObject(com.kowalczyk.workouter.model.BO.user.UserDetails baseModel) {
        baseModel.setHashedPassword(super.getObject(baseModel.getId()).getHashedPassword());
        return super.updateObject(baseModel);
    }

    private void hashUserPassword(com.kowalczyk.workouter.model.BO.user.UserDetails baseModel) {
        baseModel.setHashedPassword(bCryptPasswordEncoder.encode(baseModel.getHashedPassword()));
    }

    private void createNewUserInfo(com.kowalczyk.workouter.model.BO.user.UserDetails userDetails) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUser(userDetails);
        userInfoService.addObject(userInfo);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        com.kowalczyk.workouter.model.BO.user.UserDetails userDetails = getByLogin(s);
        return new User(userDetails.getLogin(), userDetails.getHashedPassword(), userDetails.isEnabled(), userDetails.isAccountNonExpired(), userDetails.isCredentialsNonExpired(),
                userDetails.isAccountNonLocked(), buildUserAuthority(userDetails.getRoles()));
    }

    private List<GrantedAuthority> buildUserAuthority(Set<Role> userRoles) {
        return userRoles.stream().map(userRole -> new SimpleGrantedAuthority(userRole.getRoleType().name())).collect(Collectors.toList());
    }

    @Override
    public com.kowalczyk.workouter.model.BO.user.UserDetails getByLogin(String login) {
        return ((UserDetailsDAO) getBaseDAO()).findByLogin(login);
    }

    @Override
    public void deleteObject(Long id) {
        com.kowalczyk.workouter.model.BO.user.UserDetails userDetails = super.getObject(id);
        deleteUserInfoBeforeUserIfNotNull(userDetails);
        super.deleteObject(id);
    }

    private void deleteUserInfoBeforeUserIfNotNull(com.kowalczyk.workouter.model.BO.user.UserDetails userDetails) {
        if (userDetails.getUserInfo() != null) {
            userInfoService.deleteObject(userDetails.getUserInfo());
        }
    }
}
