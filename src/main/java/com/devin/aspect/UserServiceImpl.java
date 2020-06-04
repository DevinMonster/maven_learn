package com.devin.aspect;

import com.devin.Log;
import com.devin.Reg;
import com.devin.proxy.User;

public class UserServiceImpl implements UserService {
    @Reg
    public void register(User user) {
        // 业务运算+DAO调用
        System.out.println("业务运算+DAO调用");
    }

    @Log
    @Reg
    public boolean login(String username, String password) {
        System.out.println("UserServiceImpl.login");
        return true;
    }
}
