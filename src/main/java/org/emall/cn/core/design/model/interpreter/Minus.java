package org.emall.cn.core.design.model.interpreter;

/**
 * @Description 减法表达式
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/7/4
 */
public class Minus implements Exception{
    @Override
    public int interpreter(Context context) {
        return context.getNum1()-context.getNum2();
    }
}
