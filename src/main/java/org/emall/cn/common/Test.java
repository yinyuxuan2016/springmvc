package org.emall.cn.common;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2017/1/17
 */
public class Test {
    public static void main(String[] args) {
        StringBuffer stringBuffer=new StringBuffer();
        for (int i = 0; i < 10; i++) {
            stringBuffer.append(i+",");
        }
        stringBuffer.deleteCharAt(stringBuffer.length()-1);
        System.out.println(stringBuffer.toString());
    }
}
