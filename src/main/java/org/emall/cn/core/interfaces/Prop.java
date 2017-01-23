package org.emall.cn.core.interfaces;

import java.lang.annotation.*;

/**
 * @Description 创建一个注解属性值的注解
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/7/6
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Prop {
    String key();

    String describe() default "";

    String defaultValue() default "";

    boolean isAllowNull() default false;

    boolean isTrim() default true;

    String exception() default "";
}
