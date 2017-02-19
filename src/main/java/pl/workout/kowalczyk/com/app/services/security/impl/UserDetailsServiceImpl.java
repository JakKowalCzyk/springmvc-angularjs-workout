package pl.workout.kowalczyk.com.app.services.security.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.workout.kowalczyk.com.app.dao.security.UserDetailsDao;
import pl.workout.kowalczyk.com.app.model.BO.security.UserRole;
import pl.workout.kowalczyk.com.app.services.impl.ModelServiceImpl;
import pl.workout.kowalczyk.com.app.services.security.UserDetailsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by JK on 2016-12-18.
 */
@Service
public class UserDetailsServiceImpl extends ModelServiceImpl<pl.workout.kowalczyk.com.app.model.BO.security.UserDetails> implements UserDetailsService {
    @Autowired
    private UserDetailsDao userDetailsDao;

    @Autowired
    public UserDetailsServiceImpl(UserDetailsDao baseDao) {
        super(baseDao);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        pl.workout.kowalczyk.com.app.model.BO.security.UserDetails userDetails = userDetailsDao.getByLogin(s);
        UserDetails userDetailsSecurity = new User(userDetails.getLogin(), userDetails.getPassword(), userDetails.getEnabled(), true, true,
                true, buildUserAuthority(userDetails.getUserRoles()));
        return userDetailsSecurity;
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        userRoles.forEach(userRole -> grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getRole().getName())));
        return grantedAuthorities;
    }

}