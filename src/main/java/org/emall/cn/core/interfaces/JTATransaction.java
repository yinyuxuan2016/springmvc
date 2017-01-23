package org.emall.cn.core.interfaces;

import java.lang.annotation.*;

/**
 * @Description JTA注解，用来控制事务
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/7/5
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JTATransaction {
}
