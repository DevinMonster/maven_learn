package com.devin;

import com.devin.beanpost.Category;
import com.devin.life.Product;
import com.devin.proxy.User;
import com.devin.proxy.UserService;
import com.devin.spring.demo.*;
import com.devin.spring.demo.constructer.Customer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.util.Properties;


public class TestSpring {
    /*
     *  用于测试:工厂设计模式
     * */
    @Test
    public void test() {
        UserService userService = (UserService) BeanFactory.getBean("userService");
        userService.login("hhh", "okk");

        User user = new User("sb", "123");
        userService.register(user);
    }

    /*
     *  用于测试:Person类
     * */
    @Test
    public void test2() {
        Person person = (Person) BeanFactory.getBean("person");
        System.out.println("person = " + person);
    }

    /*
     *  用于测试:spring的第一个程序
     * */
    @Test
    public void test3() {
        // 1.获得工厂,非web环境的context
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        // 2.通过工厂获得对象
        Person person = (Person) ctx.getBean("person");
        System.out.println("person = " + person);
    }

    /*
     *  用于测试:测试重载的getBean方法
     * */
    @Test
    public void test4() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
       /*Person person = ctx.getBean("person", Person.class);
       System.out.println("person = " + person);*/

        // expected single matching bean but found 2: person,person1,只允许一个Person类对象
       /*Person bean = ctx.getBean(Person.class);
       System.out.println("bean = " + bean);*/

        // 获取的是Spring工厂配置文件中所有bean标签的Id值
        //beanDefinitionName = person1
        //beanDefinitionName = person
       /*String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
       for (String beanDefinitionName : beanDefinitionNames) {
           System.out.println("beanDefinitionName = " + beanDefinitionName);
       }*/

        // 根据类型获得spring id 的对应值
       /*String[] beanNamesForType = ctx.getBeanNamesForType(Person.class);
       for (String id : beanNamesForType) {
           System.out.println("id = " + id);
       }*/

        // 用于判断是否存在指定ID值的Bean
       /*if (ctx.containsBeanDefinition("person")) {
           System.out.println("true = " + true);
       }
       if (ctx.containsBeanDefinition("a")) {
           System.out.println("true = " + true);
       }*/

        if (ctx.containsBean("person")) {
            System.out.println("good");
        }
        if (ctx.containsBean("a")) {
            System.out.println("true = " + true);
        }
    }

    /*
     *  用于测试:spring测试文件
     * */
    @Test
    public void test5() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person bean = ctx.getBean(Person.class);
        Person bean1 = ctx.getBean(Person.class);
        Person bean2 = ctx.getBean(Person.class);
        for (String id : ctx.getBeanNamesForType(Person.class)) {
            System.out.println("id = " + id);
        }
    }

    /*
     *  用于测试:name属性
     * */
    @Test
    public void test6() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person bean = (Person) ctx.getBean("p");
        Person sb = (Person) ctx.getBean("person1");
        System.out.println("sb = " + sb);
//        System.out.println("bean = " + bean);
    }
    
    /*
    *  用于测试:通过spring的配置文件进行赋值注入
    * */
    @Test
    public void test7(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person person1 = (Person) ctx.getBean("person1");

        System.out.println("person1 = " + person1);

    }

    /*
    *  用于测试:8种+string数据类型
    * */
    @Test
    public void test8(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person person = (Person) ctx.getBean("person");
        /*for (String email : person.getEmails()) {
            System.out.println("email = " + email);
        }*/
        // 不可重复但是有序的集合
        /*for (Integer code : person.getCodes()) {
            System.out.println("code = " + code);
        }*/
        // 可重复的列表
        /*for (String phone_num : person.getPhone_nums()) {
            System.out.println("phone_num = " + phone_num);
        }*/
        /*for (Integer key : person.getQqs().keySet()) {
            String value = person.getQqs().get(key);
            System.out.println("key = " + key);
            System.out.println("value = " + value);
        }*/

        Properties p = person.getP();
        System.out.println("key is key1 value is "+p.getProperty("key1"));
        System.out.println("key is key2 value is "+p.getProperty("key2"));
    }

    /*
    *  用于测试:用户自定义类型
    * */
    @Test
    public void test9(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService service = (UserService) ctx.getBean("service");
        service.register(new User("hhh","123"));
        service.login("hhh","123");
    }
    /*
    *  用于测试:简化代码后的配置
    * */
    @Test
    public void test10(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
//        Person per = (Person) ctx.getBean("per");
//        System.out.println("per = " + per);
        /*UserService ser = (UserService) ctx.getBean("ser");
        ser.login("1","2");
        ser.register(new User("1","2"));*/
        Person user = (Person) ctx.getBean("user");
        System.out.println("user = " + user);
    }

    /*
    *  用于测试:构造注入
    * */
    @Test
    public void test11(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Customer customer = (Customer) ctx.getBean("customer");
        System.out.println("customer = " + customer);
    }

    /*
    *  用于测试:FactoryBean接口
    * */
    @Test
    public void test12(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        // 获取Connection对象
        Connection conn = (Connection) ctx.getBean("conn");
        Connection conn1  = (Connection) ctx.getBean("conn");
        System.out.println(conn == conn1);
        // 获取ConnectionFactoryBean对象
        /*ConnectionFactoryBean bean = (ConnectionFactoryBean) ctx.getBean("&conn");
        System.out.println("bean = " + bean);*/
    }

    /*
    *  用于测试:spring的实例工厂
    * */
    @Test
    public void test13(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Connection conn = (Connection) ctx.getBean("conn");
        System.out.println("conn = " + conn);
    }

    /*
    *  用于测试:静态工厂
    * */
    @Test
    public void test14(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Connection conn1 = (Connection) ctx.getBean("conn1");
        System.out.println("conn1 = " + conn1);
    }

    /*
    *  用于测试:spring控制简单对象创建次数
    * */
    @Test
    public void test15(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Account account = (Account) ctx.getBean("account");
        Account ac = (Account) ctx.getBean("account");
        System.out.println(ac == account);
        
    }
    
    /*
    *  用于测试:生命周期
    * */
    @Test
    public void test16(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Product product = (Product) ctx.getBean("product");
        ctx.close();
    }

    /*
    *  用于测试:配置文件参数化
    * */
    @Test
    public void test17(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext1.xml");
        Connection conn = (Connection) ctx.getBean("conn");
        System.out.println("conn = " + conn);
    }

    /*
    *  用于测试:自定义类型转换器
    * */
    @Test
    public void test18(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext2.xml");
        com.devin.converter.Person person = (com.devin.converter.Person) ctx.getBean("person");
        System.out.println("birthday = " + person.getDate());
    }
    
    /*
    *  用于测试:BeanPostProcessor
    * */
    @Test
    public void test19(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext3.xml");
        Category c = (Category) ctx.getBean("c");
//        MyBeanPostProcessor myBeanPostProcessor = (MyBeanPostProcessor) ctx.getBean("myBeanPostProcessor");
        System.out.println("c = " + c.getName());
    }
}
