package com.devin.proxy;

public interface UserService {
    void register(User user);
    boolean login(String username, String password);
}
