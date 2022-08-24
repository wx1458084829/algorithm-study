package com.namo.exercise;

import org.junit.Test;


/**
 * @author namo
 * @date 2022/8/14-0:08
 */
public class Problem1422 {
    @Test
    public void test1() {
        int i = maxScore("011101");
        System.out.println(i);
    }

    public int maxScore(String s) {
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            int scoreZero = getScore(s.substring(0, i), '0');
            int scoreOne = getScore(s.substring(i, s.length()), '1');
            if (scoreZero + scoreOne > max) {
                max = scoreZero + scoreOne;
            }
        }
        return max;
    }

    /**
     * 统计值字符串里面ch的个数
     * @param s
     * @param ch
     * @return
     */
    public int getScore(String s, char ch) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }
}
