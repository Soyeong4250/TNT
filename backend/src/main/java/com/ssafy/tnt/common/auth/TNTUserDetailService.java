package com.ssafy.tnt.common.auth;

import com.ssafy.tnt.api.service.UserService;
import com.ssafy.tnt.db.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class TNTUserDetailService implements UserDetailsService {
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUserId(username);
        if(user != null) {
            TNTUserDetails userDetails = new TNTUserDetails(user);
            return userDetails;
        }
        return null;
    }
}
