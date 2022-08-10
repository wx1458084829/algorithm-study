package com.namo.exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author namo
 * @date 2022/8/11-0:03
 */
public class Problem1417 {
    @Test
    public void test1() {
        String res = reformat("a0b1c2");
        System.out.println(res);
    }


    /**
     * 1417. 重新格式化字符串
     * @param s
     * @return
     */
    public String reformat(String s) {
        List<Character> a = new ArrayList<>();
        List<Character> b = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                a.add(s.charAt(i));
            } else {
                b.add(s.charAt(i));
            }
        }
        System.out.println(a);
        System.out.println(b);
        if (Math.abs(a.size() - b.size()) > 1) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();

        if (a.size() > b.size()) {
            for (int i = 0; i < b.size(); i++) {
                stringBuffer.append(a.get(i));
                stringBuffer.append(b.get(i));
            }
            stringBuffer.append(a.get(a.size() - 1));
        } else if (a.size() < b.size()) {
            for (int i = 0; i < a.size(); i++) {
                stringBuffer.append(b.get(i));
                stringBuffer.append(a.get(i));
            }
            stringBuffer.append(b.get(b.size() - 1));
        }else {
            for (int i = 0; i < a.size(); i++) {
                stringBuffer.append(b.get(i));
                stringBuffer.append(a.get(i));
            }
        }
        return stringBuffer.toString();
    }
}
