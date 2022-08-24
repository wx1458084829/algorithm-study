package com.namo.exercise;

import org.junit.Test;

/**
 * @author namo
 * @date 2022/8/24-22:53
 */
public class Problem9 {
    @Test
    public void test1() {
        boolean palindrome = isPalindrome(1001);
        System.out.println(palindrome);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        String startString = s.substring(0, s.length() / 2);
        StringBuilder endString = new StringBuilder();
        if (s.length() % 2 == 0) {
            endString.append(s.substring(s.length() / 2));
        } else {
            endString.append(s.substring((s.length() / 2) + 1));
        }
        endString.reverse();
        return startString.equals(endString.toString());
    }
}
