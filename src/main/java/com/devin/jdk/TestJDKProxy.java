package com.devin.jdk;

import com.devin.proxy.User;
import com.devin.proxy.UserService;
import com.devin.proxy.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestJDKProxy {
    public static void main(String[] args) {
        // 1. 创建原始对象
        final UserService userService = new UserServiceImpl();
        // 2. JDK动态代理的创建
        final InvocationHandler invocationhandler = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("-----------log------------");
                Object invoke = method.invoke(userService, args);
                return invoke;
            }
        };
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),userService.getClass().getInterfaces(),invocationhandler);

        userServiceProxy.login("suns","123456");

        userServiceProxy.register(new User("nn","1234"));
    }
}
