package org.emall.cn.core.design.model.singleton;

/**
 * @Description 懒汉式 线程安全的一种方式
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/29
 */
public class SynSingleton {
    //定义一个静态的全局变量，用于单例的返回
    private static SynSingleton singleon=null;
    //创建一个私有的构造器就是为了不让其他类实例化该类
    private SynSingleton(){};
    //这种方式的坏处就是使用同步锁到方法级，在性能方法有一定影响
    /*public static synchronized SynSingleton getSingleon(){
        //若该实例已经实例化，则不需要再创建
        if(singleon!=null){
            return singleon;
        }else{
            singleon= new SynSingleton();
        }
        return singleon;
    }*/
    public static SynSingleton getSingleon(){
        if (singleon!=null){
            return singleon;
        }else{
            //这个地方加锁的要进行两次判断的原因就是判断在加锁前，这时候还是会发生并发的现象
            if(singleon==null){
                synchronized (singleon){
                    if (singleon==null){
                        singleon=new SynSingleton();
                    }
                }
            }
        }
        return singleon;
    }
}
