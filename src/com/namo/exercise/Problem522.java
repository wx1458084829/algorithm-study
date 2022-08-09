package com.namo.exercise;

import org.junit.Test;

//Todo 未解决问题
/**
 * @author namo
 * @date 2022/6/27-13:27
 */
public class Problem522 {
    @Test
    public void case522() {
//        System.out.println(isSame("abc", "aebdc"));
        System.out.println(findLUSlength(new String[]{"aabbcc", "aabbcc","c","e","aabbcd"}));

    }

    public int findLUSlength(String[] strs) {
        int max = -1;
        for (int i = 0; i < strs.length; i++) {
            boolean flag = true;
            for (int j = 0; j < strs.length; j++) {
                if (j != i && isSame(strs[i], strs[j]) == true) {
                    flag = false;
                }
            }
            if (flag && strs[i].length() > max) {
                max = strs[i].length();
            }
        }
        return max;
    }

    public boolean isSame(String str1, String str2) {
        //确保第一个长度大于等于第二个
        if (str1.length() - str2.length() < 0) {
            String tempStr = str1;
            str1 = str2;
            str2 = tempStr;
        }

        int i = 0;
        int j = 0;

        while (i < str1.length() & j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == str2.length() ? true : false;
    }
}
