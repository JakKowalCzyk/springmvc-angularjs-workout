package com.kowalczyk.workouter.services.user.impl;

import com.kowalczyk.workouter.dao.user.UserDAO;
import com.kowalczyk.workouter.enums.RoleType;
import com.kowalczyk.workouter.model.BO.security.Role;
import com.kowalczyk.workouter.model.BO.security.token.ResetPasswordToken;
import com.kowalczyk.workouter.model.BO.security.token.UserConfirmationToken;
import com.kowalczyk.workouter.model.BO.user.User;
import com.kowalczyk.workouter.model.BO.user.impl.UserInfo;
import com.kowalczyk.workouter.model.DTO.security.ResetPasswordObject;
import com.kowalczyk.workouter.services.impl.ModelServiceImpl;
import com.kowalczyk.workouter.services.security.RoleService;
import com.kowalczyk.workouter.services.security.token.ResetPasswordService;
import com.kowalczyk.workouter.services.security.token.UserConfirmationService;
import com.kowalczyk.workouter.services.user.UserInfoService;
import com.kowalczyk.workouter.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by JK on 2016-12-18.
 */
@Service
public class UserServiceImpl extends ModelServiceImpl<User> implements UserService {

    private UserInfoService userInfoService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserConfirmationService userConfirmationService;
    private RoleService roleService;
    private ResetPasswordService resetPasswordService;

    @Autowired
    public UserServiceImpl(UserDAO baseDao, UserInfoService userInfoService, BCryptPasswordEncoder bCryptPasswordEncoder, UserConfirmationService userConfirmationService, RoleService roleService,
                           ResetPasswordService resetPasswordService) {
        super(baseDao);
        this.userInfoService = userInfoService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userConfirmationService = userConfirmationService;
        this.roleService = roleService;
        this.resetPasswordService = resetPasswordService;
    }

    @Override
    public User addObject(User baseModel) {
        hashUserPassword(baseModel);
        baseModel.setAccountNonExpired(false);
        baseModel.setCredentialsNonExpired(false);
        baseModel.setEnabled(false);
        baseModel.setAccountNonLocked(false);
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
    public void startConfirmationProcedure(String uri, Long userId) {
        userConfirmationService.startTokenProcedure(super.getObject(userId), uri);
    }

    @Override
    public boolean confirmAccount(String token) {
        Optional<UserConfirmationToken> userOptional = userConfirmationService.findByToken(token);
        if (!userOptional.isPresent()) {
            return false;
        }
        User userToBeConfirmed = userOptional.get().getUser();
        userToBeConfirmed.setAccountNonExpired(true);
        userToBeConfirmed.setAccountNonLocked(true);
        userToBeConfirmed.setCredentialsNonExpired(true);
        userToBeConfirmed.setEnabled(true);
        updateObject(userToBeConfirmed);
        userConfirmationService.deleteByUser(userToBeConfirmed);
        return true;
    }

    @Override
    public User createSocialAccount(org.springframework.social.facebook.api.User socialUser) {
        User user = new User();
        user.setFirstName(socialUser.getFirstName());
        user.setLastName(socialUser.getLastName());
        Random random = new Random();
        user.setHashedPassword(Long.toHexString(Double.doubleToLongBits(random.nextInt(8))));
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setEmail(socialUser.getEmail());
        user.setLogin(socialUser.getId());
        user.getRoles().add(roleService.findByRoleType(RoleType.USER));
        hashUserPassword(user);
        user = super.addObject(user);
        createNewUserInfo(user);
        return user;
    }

    @Override
    public void startResetPasswordProcedure(Long userId, String body) {
        resetPasswordService.startTokenProcedure(super.getObject(userId), body);
    }

    @Override
    public boolean resetPassword(ResetPasswordObject resetPasswordObject) {
        Optional<ResetPasswordToken> resetPasswordTokenOptional = resetPasswordService.findByToken(resetPasswordObject.getToken());
        if (!resetPasswordTokenOptional.isPresent()) {
            return false;
        }
        ResetPasswordToken resetPasswordToken = resetPasswordTokenOptional.get();
        if (resetPasswordToken.getExpiryDate().before(new GregorianCalendar().getTime())) {
            resetPasswordService.deleteObject(resetPasswordToken);
            return false;
        }
        User user = resetPasswordToken.getUser();
        user.setHashedPassword(bCryptPasswordEncoder.encode(resetPasswordObject.getNewPassword()));
        updateObject(user);

        return true;
    }

    @Override
    public void deleteObject(Long id) {
        User user = super.getObject(id);
        deleteUserInfoBeforeUserIfNotNull(user);
        deleteConfirmationToken(user);
        super.deleteObject(id);
    }

    private void deleteUserInfoBeforeUserIfNotNull(User user) {
        if (user.getUserInfo() != null) {
            userInfoService.deleteObject(user.getUserInfo());
        }
    }

    private void deleteConfirmationToken(User user) {
        userConfirmationService.deleteByUser(user);
    }
}
