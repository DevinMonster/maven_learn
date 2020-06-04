package com.devin.spring.demo;

import com.devin.proxy.User;

public class UserDAOImpl implements UserDAO{
    public void save(User user) {
        System.out.println("insert into user=" + user);
    }

    public void queryUserByUserNameAndPassword(String name, String password) {
        System.out.println("select User name="+name+" password="+password);
    }
}
