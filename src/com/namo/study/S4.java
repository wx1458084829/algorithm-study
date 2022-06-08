package com.namo.study;

import org.junit.Test;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * 217. 存在重复元素
 */
public class S4 {


    @Test
    void mainTest() {
        int[] nums = new int[]{1, 1, 2, 3, 4, 5, 6};
        boolean b = containsDuplicate(nums);
        System.out.println(b);
    }


    /**
     * 基本解法
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * set解法
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {
        TreeSet<Integer> integers = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            integers.add(nums[i]);
        }
        //比较长度是否一致
        return nums.length == integers.size() ? false : true;
    }

    /**
     * set解法优化
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate3(int[] nums) {
        TreeSet<Integer> integers = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            //插入失败就返回结果
            if (!integers.add(nums[i])) {
                return true;
            }
        }
        return false;
    }


}
