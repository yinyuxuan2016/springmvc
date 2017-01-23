package org.emall.cn.core.design.model.chain;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/30
 */
public class MyHandle extends AbstractHandle implements Handle{
    private String name;
    public MyHandle(String name) {
        this.name = name;
    }
    @Override
    public void operation() {
        System.out.println(name+"  is dealing");
        if(this.getHandle()!=null){
            getHandle().operation();
        }
    }

    public static void main(String[] args) {
        MyHandle m1=new MyHandle("m1");
        MyHandle m2=new MyHandle("m2");
        MyHandle m3=new MyHandle("m3");
        m1.setHandle(m2);
        m2.setHandle(m3);
        m1.operation();
    }
}
