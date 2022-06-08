package com.namo.string;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class kmp {
    static Map<String, String> testData = new HashMap<>();

    @Before
    public void initData() {
        testData.put("ABCABCDHIJK", "ABCE");
        testData.put("ABCDEFGHIJK", "EFGH");
    }


    @Test
    public void mainTest() {
        testData.forEach((key, value) -> {
            System.out.println(bf(key, value));
        });
    }

    /**
     * @param ts 主串
     * @param ps 模式串
     * @return 如果找到，返回在主串中第一个字符出现的下标，否则为-1
     */
    public static int bf(String ts, String ps) {
        char[] tsChars = ts.toCharArray();
        char[] psChars = ps.toCharArray();
        int tap = 1;
        for (int i = 0; i < tsChars.length - psChars.length; i++) {
            boolean flag = true;
            for (int j = 0; j < psChars.length; j++) {
                if (tsChars[j+tap] != psChars[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i+1;
            }
            tap ++;
        }
        return -1;
    }


    /**
     * @param ts 主串
     * @param ps 模式串
     * @return 如果找到，返回在主串中第一个字符出现的下标，否则为-1
     */
//    public static int bf(String ts, String ps) {
//        char[] t = ts.toCharArray();
//        char[] p = ps.toCharArray();
//        int i = 0; // 主串的位置
//        int j = 0; // 模式串的位置
//        while (i < t.length && j < p.length) {
//            if (t[i] == p[j]) { // 当两个字符相同，就比较下一个
//                i++;
//                j++;
//            } else {
//                i = i - j + 1; // 一旦不匹配，i后退
//                j = 0; // j归0
//            }
//        }
//        if (j == p.length) {
//            return i - j;
//        } else {
//            return -1;
//        }
//    }
}
