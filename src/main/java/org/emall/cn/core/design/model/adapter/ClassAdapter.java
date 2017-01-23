package org.emall.cn.core.design.model.adapter;

/**
 * @Description 类适配器
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/29
 */
public class ClassAdapter extends Soucre implements IAdapter{
    public void method2() {
        System.out.println("this is target method!!!");
    }

    public static void main(String[] args) {
        ClassAdapter classAdapter=new ClassAdapter();
        classAdapter.method2();
        //method1是source的方法，通过Source类来适配IAdapter的method1方法
        classAdapter.method1();
    }
}
