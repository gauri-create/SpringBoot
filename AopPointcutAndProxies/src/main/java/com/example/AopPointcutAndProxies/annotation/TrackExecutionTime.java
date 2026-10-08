package com.example.AopPointcutAndProxies.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TrackExecutionTime
 */

//marker annotation

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented

public @interface TrackExecutionTime {
    long warnAfter() default 2000;

    String operation()  default "";

}
