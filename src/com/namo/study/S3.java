package com.namo.study;

import org.junit.Test;

import java.util.Arrays;

/**
 * 26. 删除有序数组中的重复项
 */
public class S3 {
    static int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

    @Test
    public void testMain() {
        int i = removeDuplicates(nums);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        int index1 = 1;
        int index2 = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index1] != nums[i]) {
                for (int j = index1; j < i; j++) {
                    nums[index1] = nums[i];
                }
                index1++;
            }
        }
        return 0;
    }

    public void swap(int[] nums, int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }


}
