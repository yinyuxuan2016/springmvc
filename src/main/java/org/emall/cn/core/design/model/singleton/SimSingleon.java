package org.emall.cn.core.design.model.singleton;

/**
 * @Description 简单的单例模式（懒汉式）
 * 应用场景：一个无状态的类使用单例模式节省开销
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/29
 */
public class SimSingleon {
    //定义一个静态的全局变量，用于单例的返回
    private static SimSingleon singleon=null;
    //创建一个私有的构造器就是为了不让其他类实例化该类
    private SimSingleon(){};
    public static SimSingleon getSingleon(){
        //若该实例已经实例化，则不需要再创建
        if(singleon!=null){
            return singleon;
        }else{
            singleon= new SimSingleon();
        }
        return singleon;
    }
}
