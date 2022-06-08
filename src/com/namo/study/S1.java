package com.namo.study;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

/**
 * 删除排序数组中的重复项
 */
public class S1 {
    static int[] a;


    @Before
    public void initData() {
        a = new int[]{1, 1, 2, 3, 4, 4, 5, 5, 6, 7, 8, 8};
    }

    @Ignore
    @Test
    public void test1(){

        System.out.println(Arrays.toString(a));
    }


//    public int removeDuplicates(int[] nums) {
//
//    }
}
