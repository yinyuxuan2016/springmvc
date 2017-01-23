package org.emall.cn.core.design.model.adapter;

/**
 * @Description 对象适配器
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/29
 */
public class ObjectAdapter implements IAdapter{
    private Soucre soucre;
    //将要适配的类作为对象初始化到适配器中
    public ObjectAdapter(Soucre soucre) {
        this.soucre = soucre;
    }
    @Override
    public void method1() {
        soucre.method1();
    }
    @Override
    public void method2() {
        System.out.println("this is implement method!!!");
    }

    public static void main(String[] args) {
        Soucre soucre=new Soucre();
        ObjectAdapter objectAdapter=new ObjectAdapter(soucre);
        objectAdapter.method1();
        objectAdapter.method2();
    }
}
