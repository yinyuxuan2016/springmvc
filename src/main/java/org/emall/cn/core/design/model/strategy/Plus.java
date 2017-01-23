package org.emall.cn.core.design.model.strategy;

/**
 * @Description 加法策略
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/30
 */
public class Plus extends AbstractCaculator implements ICaculator {
    @Override
    public int caculator(String exp) {
        int[] arr=this.split(exp,"\\+");
        return arr[0]+arr[1];
    }
}
