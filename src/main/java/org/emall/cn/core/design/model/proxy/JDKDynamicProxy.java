package org.emall.cn.core.design.model.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description jdk动态代理实现InvocationHandler接口该接口是jdk提供的,
 * 和cglib的区别就是创建代理快，数据量少的时候代理性能比cglib快，但是数据量大的话
 * cglib比较快，但是随着jdk的版本迭代，jdk动态代理的性能在提升，而cglib的性能
 * 没有太大的改变，jdk持有被代理对象的实例，然后调用实例进行代理
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/29
 */
public class JDKDynamicProxy implements InvocationHandler{
    private ISource source;

    public JDKDynamicProxy(ISource source) {
        this.source = source;
    }

    public static ISource newInstance(ISource target){
        return (ISource) Proxy.newProxyInstance(JDKDynamicProxy.class.getClassLoader(),new Class[]{ISource.class},new JDKDynamicProxy(target));
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk proxy............");
        return method.invoke(source,args);
    }

    public static void main(String[] args) {
        ISource source=JDKDynamicProxy.newInstance(new SourceImpl());
        source.method();
    }
}
