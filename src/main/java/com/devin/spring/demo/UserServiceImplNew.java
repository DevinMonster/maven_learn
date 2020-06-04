package com.devin.spring.demo;

import com.devin.Log;
import com.devin.proxy.User;
import com.devin.proxy.UserService;

public class UserServiceImplNew implements UserService {
    @Log
    public void register(User user) {
        System.out.println("new Impl="+user);
    }

    public boolean login(String username, String password) {
        System.out.println("username = "+username+" password="+password);
        return true;
    }
}
