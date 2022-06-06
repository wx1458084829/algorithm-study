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
        Assert.assertTrue(repeatedSubstringPattern(testStrings[0]));
        Assert.assertFalse(repeatedSubstringPattern(testStrings[1]));
        Assert.assertTrue(repeatedSubstringPattern(testStrings[2]));

    }

    @Test
    public void test2(){
        System.out.println("abc".charAt(1));
    }



    public boolean repeatedSubstringPattern(String s) {
        for (int i = 0; i < s.length()/2; i++) {
            String temp = s.substring(0,i+1);
            String[] split = s.split(temp);
            if (split.length == 0){
                return true;
            }
            for (int j = 0; j < split.length; j++) {
                if (split[j].equals("") == true){
                    continue;
                }else if(j == split.length){
                    return true;
                } else {
                    break;
                }
            }
        }
        return false;
    }
}
