package com.namo.exercise;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * <p>
 * 注意：请不要在超过该数组长度的位置写入元素。
 * <p>
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * 示例 2：
 * <p>
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/duplicate-zeros
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author namo
 * @date 2022/6/17-10:37
 */
public class Problem1089 {
    @Test
    public void Case1089() {
        int[] a = new int[]{0, 0, 0, 0, 0, 0, 0};
        this.duplicateZeros(a);
        System.out.println(Arrays.toString(a));
    }


    public void duplicateZeros(int[] arr) {
        int[] tempArr = new int[arr.length];
        tempArr[arr.length - 1] = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        while (tempArr[arr.length - 1] == Integer.MIN_VALUE) {
            if (arr[i] == 0) {
                tempArr[j] = arr[i];
                if (j < tempArr.length && j < tempArr.length - 1) {
                    j++;
                    tempArr[j] = 0;
                }
                i++;
                j++;
            } else {
                tempArr[j] = arr[i];
                i++;
                j++;
            }
        }
        for (int k = 0; k < arr.length; k++) {
            arr[k] = tempArr[k];
        }
    }
    //todo 题解解决方案
}
