package com.namo.exercise;

import org.junit.Test;
//todo 优秀解法
/**
 * @author namo
 * @date 2022/8/9-18:24
 */
public class Problem1413 {


    @Test
    public void case1() {
        int[] a = new int[]{-3, 2, -3, 4, 2};
        int out = minStartValue(a);
        System.out.println(out);
    }

    @Test
    public void case2() {
        int[] a = new int[]{1,2};
        int out = minStartValue(a);
        System.out.println(out);
    }

    @Test
    public void case3() {
        int[] a = new int[]{1,-2,-3};
        int out = minStartValue(a);
        System.out.println(out);
    }



    public int minStartValue(int[] nums) {
        int startValue = 1;
        int maxValue = 1;
        for (int item : nums) {
            if (item > 0) {
                startValue -= item;
            } else {
                startValue += Math.abs(item);
            }
            if (startValue > maxValue) {
                maxValue = startValue;
            }
        }
        return maxValue;
    }
}
