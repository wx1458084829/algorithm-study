package com.namo.temp;

import org.junit.Test;

import java.util.*;

/**
 * @author namo
 * @date 2022/3/31-20:19
 */
public class Main {
    @Test
    public void mainTest() {
        System.out.println("这是临时测试代码！");
    }

    @Test
    public void addTest() {
        long a[] = {1, 2, 3};
        long b[] = {4, 5, 6};
        b = addFn(b);
        // 注意运算顺序
        System.out.print(a[1] + a[2] + " " + a[0]);
        System.out.println(b[1] + b[2] + b[0]);
    }

    public long[] addFn(long[] c) {
        c[1] = 100;
        new String();
        String s = new String("s");
        new String();
        return c;
    }


    /**
     * 寻找数组中最大的排列数
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * func lengthOfMaxQueue(nums []int) int {
     * return 0
     * }
     *
     * @param nums int整型ArrayList
     * @return int整型
     */
    public int lengthOfMaxQueue(ArrayList<Integer> nums) {
        return 0;
    }


}
