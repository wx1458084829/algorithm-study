package com.namo.exercise;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//Todo 未解决问题
/**
 * @author namo
 * @date 2022/6/28-17:34
 */
public class Problem324 {
    /**
     * 主要测试
     */
    @Test
    public void case324() {
        wiggleSort(new int[]{1,3,2,2,3,1});
    }

    /**
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        Deque<Integer> queue = new LinkedList<>();
        for (int item : nums) {
            queue.add(item);
        }

        int i = 0;
        boolean flag = true;
        while (queue.isEmpty() == false) {
            if (flag) {
                nums[i] = queue.pollFirst();
            } else {
                nums[i] = queue.pollLast();
            }
            i++;
            flag = !flag;
        }
    }
}
