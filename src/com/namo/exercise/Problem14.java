package com.namo.exercise;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

/**
 * @author namo
 * @date 2022/8/24-23:32
 */
public class Problem14 {
    @Test
    public void test1() {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));

    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder();
        Optional<String> max = Arrays.stream(strs).max((o1, o2) -> {
            return o1.length() - o2.length();
        });
        char[][] ch = new char[strs.length][max.get().length()];
        Optional<String> min = Arrays.stream(strs).min((o1, o2) -> {
            return o1.length() - o2.length();
        });

        for (int i = 0; i < strs.length; i++) {
            ch[i] = strs[i].toCharArray();
        }

        for (int i = 0; i < min.get().length(); i++) {
            boolean flag = true;
            for (int j = 0; j < ch.length; j++) {
                if (ch[j][i] != ch[0][i]) {
                    flag = false;
                    break;
                }
            }
            if (flag){
                stringBuilder.append(ch[0][i]);
            }else {
                break;
            }
        }
        return stringBuilder.toString();
    }
}
