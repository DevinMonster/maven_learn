package com.devin.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUSProcessor implements BeanPostProcessor {
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        InvocationHandler handler = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("---------new log------------");
                Object invoke = method.invoke(bean, args);
                return invoke;
            }
        };

        return Proxy.newProxyInstance(this.getClass().getClassLoader(),bean.getClass().getInterfaces(),handler);
    }
}
