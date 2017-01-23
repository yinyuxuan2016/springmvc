package org.emall.cn.core.design.model.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description cglib动态代理实现spring中的MethodInterceptor接口，使用enhance进行创建代理类
 * 接口对象也就是被代理的对象作为代理对象的父类对象
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/29
 */
public class CglibDynamicProxy implements MethodInterceptor{
    public static ISource newGetInstance(ISource source){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(source.getClass());
        enhancer.setCallback(new CglibDynamicProxy());
        return (ISource) enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib proxy.............");
        return methodProxy.invokeSuper(o,objects);
    }

    public static void main(String[] args) {
        ISource source=CglibDynamicProxy.newGetInstance(new SourceImpl());
        source.method();
    }
}
