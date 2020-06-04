package com.devin.proxy;

public class UserServiceProxy implements UserService{
    private UserServiceImpl userService = new UserServiceImpl();

    public void register(User user) {
        System.out.println("---log1----");
        userService.register(user);
    }

    public boolean login(String username, String password) {
        System.out.println("----log2----");
        return userService.login(username, password);
    }
}
