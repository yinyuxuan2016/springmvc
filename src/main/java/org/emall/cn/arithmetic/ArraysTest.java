package org.emall.cn.arithmetic;

import java.util.Arrays;

/**
 * @Description 冒泡算法
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2017/2/16
 */
public class ArraysTest {
    public static void main(String[] args) {
        int    array[] = {15, 225, 34, 42, 52, 6, 7856, 865, 954, 10};
        int temp=0;
        for (int i = 0; i <array.length ; i++) {
            for (int j = 1; j <array.length-i ; j++) {
                if (array[j-1]>array[j]){
                    temp=array[j-1];
                    array[j-1]=array[j];
                    array[j]=temp;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    public static void  swap(int a, int b)
    {
        int  temp;
        temp = a;
      a = b;
      b = temp;
    }


}
