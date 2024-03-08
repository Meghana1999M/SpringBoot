package com.example.SpringBoot.config;

import org.springframework.boot.logging.LogLevel;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Loggable {
    boolean params() default true;
    boolean result() default true;
    LogLevel value() default LogLevel.DEBUG;
}
