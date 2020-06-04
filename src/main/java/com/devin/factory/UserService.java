package com.devin.factory;

import com.devin.proxy.User;

public interface UserService {
    void login(String name, String pass);

    void register(User user);
}
