package com.namo.study;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * 459. 重复的子字符串
 */
public class S2 {
    //测试用例个数
    private static final Integer length = 3;
    static String[] testStrings;

    @Before
    public void initData() {
        testStrings = new String[length];
        testStrings[0] = "abab";
        testStrings[1] = "aba";
        testStrings[2] = "abcabcabcabc";
    }

    @Test
    public void mainTest(){
        Assert.assertTrue("abab",repeatedSubstringPattern(testStrings[0]));
        Assert.assertFalse("aba",repeatedSubstringPattern(testStrings[1]));
        Assert.assertTrue( "abcabcabcabc",repeatedSubstringPattern(testStrings[2]));

    }

    @Test
    public void test2(){
        System.out.println("abc".charAt(1));
    }



    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; ++i) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; ++j) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }
}
