package com.devin.aspect;

import com.devin.proxy.User;

public interface UserService {
    void register(User user);
    boolean login(String username, String password);
}
