package com.devin.factory;

import com.devin.proxy.User;

public class UserServiceImpl implements UserService{
    public void login(String name, String pass) {
        System.out.println("name = " + name + ", pass = " + pass);
    }

    public void register(User user) {
        System.out.println("user = " + user);
    }
}
