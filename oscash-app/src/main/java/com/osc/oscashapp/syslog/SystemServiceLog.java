package com.osc.oscashapp.syslog;

import java.lang.annotation.*;

/**
 * @description: 自定义注解 拦截service
 * @author: lizhiming
 * @since: 2017/11/30
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemServiceLog {
    String description() default "";
}
