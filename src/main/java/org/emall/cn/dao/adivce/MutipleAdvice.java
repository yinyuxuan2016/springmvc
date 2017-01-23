package org.emall.cn.dao.adivce;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.emall.cn.core.interfaces.BiDSChoicer;
import org.emall.cn.dao.dataSource.MultipleDataSource;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description 多数据源路由的AOP, 在进行dao操作前先切换数据源
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/7/5
 */
@Aspect
@Component
@Order(1)
public class MutipleAdvice implements MethodBeforeAdvice {
    /*@Around(value = "execution(* *org.emall.cn.dao.impl.*DAOImpl.* (..))", argNames = "pjp")
    public Object doException(ProceedingJoinPoint pjp) {
        Object obj = null;
        try {
            Object target = pjp.getTarget();
            Method[] methods=target.getClass().getDeclaredMethods();
            for (Method m:
                 methods) {
                BiDSChoicer annotation=m.getAnnotation(BiDSChoicer.class);
                if (annotation!=null){
                    String  dsName = annotation.dsName();
                    if (dsName != null && !"".equals(dsName)) {
                        MultipleDataSource.setDataSourceKey(dsName);
                    }
                }

            }
            //BiDSChoicer annotation= target.getClass().getAnnotation(BiDSChoicer.class);
            obj = pjp.proceed();

        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            MultipleDataSource.toDefault();
        }
        return obj;
    }*/
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {

        BiDSChoicer annotation = method.getAnnotation(BiDSChoicer.class);
        if (annotation != null)
            MultipleDataSource.setDataSourceKey(annotation.dsName());
        else
            MultipleDataSource.toDefault();
    }
}
