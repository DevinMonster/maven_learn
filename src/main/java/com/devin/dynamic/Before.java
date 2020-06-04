package com.devin.dynamic;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class Before implements MethodBeforeAdvice {
    /*
        需要把额外功能写在这块，这块会在目标类调用方法前执行
     */
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("method-before-advice");
    }
}
