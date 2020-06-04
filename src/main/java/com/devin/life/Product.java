package com.devin.life;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Product implements InitializingBean, DisposableBean {
//public class Product{
    public Product() {
        System.out.println("Product.Product");
    }
    // 程序员根据需求完成的方法
    public void afterPropertiesSet() throws Exception {
        System.out.println("Pr");
    }

    public void doInBack(){
        System.out.println("Product.doInBack");
    }

    public void destroy() throws Exception {
        System.out.println("Product.destroy");
    }

    public void mydestory() throws Exception {
        System.out.println("Product.mydestory");
    }
}
