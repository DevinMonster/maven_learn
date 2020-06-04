package com.devin.spring.demo;

import com.devin.proxy.User;

public interface UserDAO {
    void save(User user);
    void queryUserByUserNameAndPassword(String name, String password);
}
