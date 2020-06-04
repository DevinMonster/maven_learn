package com.devin;

import com.devin.proxy.OrderService;
import com.devin.proxy.User;
import com.devin.proxy.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDynamic {

    /*
    *  用于测试:动态代理对象的创建
    * */
    @Test
    public void test0(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext4.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.login("1","1");
        userService.register(new User("admin","123456"));
        OrderService orderService = (OrderService) ctx.getBean("orderService");
        orderService.showOrder();
    }
}
