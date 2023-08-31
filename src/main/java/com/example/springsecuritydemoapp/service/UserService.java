package com.example.springsecuritydemoapp.service;

import com.example.springsecuritydemoapp.user.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private User user;

    public UserService(){
        user = new User("jarvis",
                        "$2a$12$cxp.qqj5zo.yBIemacvWPO3MyK3ouozFY8VyaF7OCKUtylH/e3k1u",
                          true);
    }

    public User getUserByUsername(String username){
        return user.getUsername().equals(username)?user:null;
    }

}
