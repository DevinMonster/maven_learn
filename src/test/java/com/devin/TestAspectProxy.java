package com.devin;

import com.devin.aspect.UserService;
import com.devin.proxy.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspectProxy {
    /*
    *  用于测试:自己的切面类
    * */
    @Test
    public void test(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext6.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.login("1","1");
        userService.register(new User("1","1"));
    }
}
