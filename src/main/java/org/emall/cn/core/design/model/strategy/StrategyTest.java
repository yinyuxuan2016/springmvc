package org.emall.cn.core.design.model.strategy;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/30
 */
public class StrategyTest {
    public static void main(String[] args) {
        /*ICaculator caculator=new Multiply();
        int num=caculator.caculator("2*4");
        System.out.println(num);*/
        ICaculator caculator=new Plus();
        int num=caculator.caculator("2+4");
        System.out.println(num);
    }
}
