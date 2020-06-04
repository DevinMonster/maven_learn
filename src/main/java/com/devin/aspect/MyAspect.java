package com.devin.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {
    @Pointcut("execution(* login(..))")
    public void loginPointCut(){}
    // 切入点
    @Around("loginPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 额外功能
        System.out.println("before 切面");
        // 原始功能
        Object proceed = joinPoint.proceed();

        return proceed;
    }

    @Around("loginPointCut()")
    public Object around1(ProceedingJoinPoint joinPoint) throws Throwable {
        // 额外功能
        System.out.println("新功能");
        // 原始功能
        Object proceed = joinPoint.proceed();

        return proceed;
    }
}
