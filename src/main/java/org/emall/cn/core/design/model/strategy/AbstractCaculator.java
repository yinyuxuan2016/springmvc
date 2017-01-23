package org.emall.cn.core.design.model.strategy;

/**
 * @Description 封装了数据的处理方法
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/30
 */
public abstract  class AbstractCaculator {
    public int[] split(String exp,String opt){
        int[] arr=new int[2];
        String[] arrS=exp.split(opt);
        arr[0]=Integer.parseInt(arrS[0]);
        arr[1]=Integer.parseInt(arrS[1]);
        return arr;
    }
}
