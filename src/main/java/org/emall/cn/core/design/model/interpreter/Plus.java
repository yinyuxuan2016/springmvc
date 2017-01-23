package org.emall.cn.core.design.model.interpreter;

import java.lang.*;

/**
 * @Description 加法表达式
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/7/4
 */
public class Plus  implements Exception{
    @Override
    public  int interpreter(Context context) {
        return context.getNum1()+context.getNum2();
    }
}
