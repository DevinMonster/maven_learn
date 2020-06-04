package com.devin;

import com.devin.proxy.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProxy {

    /*
     *  用于测试:静态代理
     * */
    @Test
    public void test() {
        UserService userService = new UserServiceProxy();
        userService.login("1", "2");
        userService.register(new User("1", "2"));

        System.out.println("-----------------");
        OrderService orderService = new OrderServiceProxy();
        orderService.showOrder();

    }

    /*
     *  用于测试:spring源码实现代理
     * */
    @Test
    public void test1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext5.xml");
        com.devin.factory.UserService userService = (com.devin.factory.UserService) ctx.getBean("userService");
        userService.login("1111","2222");
    }
}
