package ru.yandex.test_task.utils;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RateLimited {
    int value() default 1;
    long interval() default 1000;
}
