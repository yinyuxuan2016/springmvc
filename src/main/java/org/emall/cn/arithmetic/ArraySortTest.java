package org.emall.cn.arithmetic;

import java.util.Arrays;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2017/2/16
 */
public class ArraySortTest {
    public static void main(String[] args) {
        int    array[] = {15, 225, 34, 42, 52, 6, 7856, 865, 954, 10};
        Arrays.sort(array);
        for (int i = 0; i <array.length ; i++) {
            System.out.println(array[i]);
        }

    }
}
