package org.emall.cn.core.design.model.proxy;

/**
 * @Description 代理模式 我所理解的代理模式就是代理对象会持有被代理的目标对象的实例，对该实例的方法进行操作
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/29
 */
public class SourceProxy implements ISource{
    private ISource source;

    public SourceProxy(ISource source) {
        this.source = source;
    }

    @Override
    public void method() {
        this.before();
        source.method();
        this.after();
    }
    private void before(){
        System.out.println("proxy before.......");
    }
    private void after(){
        System.out.println("proxy after........");
    }

    public static void main(String[] args) {
        ISource source=new SourceProxy(new SourceImpl());
        source.method();
    }
}
