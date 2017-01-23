package org.emall.cn.core.jvm;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2017/1/13
 */
public class NumberFormatUtil {
    public static  int getBinaryInt(String number){
        int a=-1;
        a=Integer.parseInt(number,2);
        return a;
    }
    public static int getBinaryIntList(){
        int a=0b0100;
        return a;
    }
    public static void main(String[] args) {
        System.out.println(getBinaryInt("0100"));
        System.out.println(getBinaryIntList());
    }
}
