package com.devin.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TestCglib {
    public static void main(String[] args) {
        // 1. 原始对象
        final UserService userService = new UserService();
        // 2.通过cglib创建动态代理对象
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(userService.getClass().getClassLoader());
        enhancer.setSuperclass(UserService.class);
        MethodInterceptor interceptor = new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println(".....额外功能。。。。。");
                Object invoke = method.invoke(userService, objects);
                System.out.println("......后续功能。。。。。。。。");
                return invoke;
            }
        };
        enhancer.setCallback(interceptor);

        UserService proxy = (UserService) enhancer.create();
        proxy.login();
        proxy.register();
    }
}
