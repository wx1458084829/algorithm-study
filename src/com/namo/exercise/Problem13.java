package com.namo.exercise;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author namo
 * @date 2022/8/24-23:02
 */
public class Problem13 {
    @Test
    public void test1(){
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));

    }

    public int romanToInt(String s) {
        int num = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        for (int i = 0; i < s.length(); i++) {
            char si = s.charAt(i);
            if (i<s.length()-1&&map.get(si)<map.get(s.charAt(i+1))){
                num += (map.get(s.charAt(i+1))-map.get(si));
                i++;
                continue;
            }
            num += map.get(si);
        }
        return num;
    }


//    未认真看题
//    public int romanToInt(String s) {
//        int sNumber = Integer.valueOf(s);
//        while (sNumber != 0) {
//            System.out.println(sNumber % 10);
//            sNumber = sNumber / 10;
//        }
//        Map<Integer, String> map = new HashMap<>();
//        map.put(1000, "M");
//        map.put(500, "D");
//        map.put(100, "C");
//        map.put(50, "L");
//        map.put(10, "X");
//        map.put(5, "V");
//        map.put(1, "I");
//        map.forEach((key, value) -> {
//        });
//        return 0;
//    }
}
