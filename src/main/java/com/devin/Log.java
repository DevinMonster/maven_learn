package com.devin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 第一个元注解决定在哪使用，这里是方法中使用
@Target(ElementType.METHOD)
// 第二个注解决定这个什么时候起作用
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
}
