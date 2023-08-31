package com.example.springsecuritydemoapp.security;

import com.example.springsecuritydemoapp.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService service;

    public UserDetailsServiceImpl(UserService service) {
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = service.getUserByUsername(username);
        if(userDetails != null)
            return userDetails;
        else
            throw new UsernameNotFoundException(username+" does not exist");
    }
}
