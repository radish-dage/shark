package com.shark.annotation;

import com.shark.common.HttpCode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 请求路径到方法的映射注解
 * @Retention:什么时候使用该注解
 * @Target:注解用于什么地方
 * RetentionPolicy.RUNTIME:始终不会丢弃，运行期间也保留该注解，因此可以使用反射机制读取该注解信息
 * ElementType.METHOD:该注解用于描述方法
 *
 * @Author dage
 * @Date 2020/11/17 22:15
 * @Version 1.0
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RequestUrlMapping {

    /**
     * 请求路径映射
     * @return
     */
    String url();

    /**
     * 请求方法类型，默认GET方式
     * @return
     */
    String type() default HttpCode.GET;
}
