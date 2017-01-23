package org.emall.cn.core.design.model.adapter;

/**
 * @Description 接口适配器
 * 该接口中有两个实现的适配器，source和target的适配器
 * 具体的适配器适配自己的资源
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/29
 */
public abstract class InterfaceAdapter implements IAdapter{
    public void method1(){}
    public void method2(){}

    public static void main(String[] args) {
        SourceAdapter sourceAdapter=new SourceAdapter();
        //sourceAdapter.method2();
        sourceAdapter.method1();
        TargetAdapter targetAdapter=new TargetAdapter();
        //targetAdapter.method1();
        targetAdapter.method2();
    }
}
