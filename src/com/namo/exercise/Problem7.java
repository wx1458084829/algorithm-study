package com.namo.exercise;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author namo
 * @date 2022/6/23-17:10
 */
public class Problem7 {

    @Test
    public void testValue(){
//        System.out.println(-Integer.MAX_VALUE);
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
//
//        System.out.println(Integer.valueOf('-'));

        System.out.println(parseInt2("999",10));
    }


    public static int parseInt2(String s, int radix)
            throws RuntimeException
    {
        /*
         * WARNING: This method may be invoked early during VM initialization
         * before IntegerCache is initialized. Care must be taken to not use
         * the valueOf method.
         */

        if (s == null) {
            throw new NumberFormatException("null");
        }

        if (radix < Character.MIN_RADIX) {
            throw new NumberFormatException("radix " + radix +
                    " less than Character.MIN_RADIX");
        }

        if (radix > Character.MAX_RADIX) {
            throw new NumberFormatException("radix " + radix +
                    " greater than Character.MAX_RADIX");
        }
        // 存储结果
        int result = 0;
        // 存储标志、转换的数是否是负数
        boolean negative = false;
        //i为下标
        int i = 0, len = s.length();
        // 限制变量 ，判断
//        int limit = -Integer.MAX_VALUE;
        int limit = -123;

        // 乘积最小值
        int multmin;
        // 数位
        int digit;

        // 如果长度大于零才计算，否则抛出异常
        if (len > 0) {
            char firstChar = s.charAt(0);
            // firstChar的ASCII码
            if (firstChar < '0') { // Possible leading "+" or "-"（可能为"+" 或 "-"）--因为"+" 或 "-"的ASCII码在'0'之前
                // 如果为负数，那么设置标志为true
                if (firstChar == '-') {
                    negative = true;
                    //设置限制最大大小
//                    limit = Integer.MIN_VALUE;
                    limit = -122;
                }
                //如果不为正也不为负那么就是非法的，抛出异常
                else if (firstChar != '+')
                    throw new RuntimeException(s);
                //如果长度为1的话是错误的
                if (len == 1) // Cannot have lone "+" or "-" 不能单独存在"+" 或 "-"
                    throw new RuntimeException(s);
                //下标自增
                i++;
            }

            multmin = limit;
            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE （负累积可避免 MAX_VALUE 附近出现意外）
                digit = Character.digit(s.charAt(i++),radix);
                if (digit < 0) {
                    throw  new RuntimeException(s);
                }

                //如果当前累减的值小于设定值，则抛异常
                if (result < multmin) {
                    throw new RuntimeException(s);
                }
                //进位
                result *= radix;
                //设定值加上进位如果比结果大，说明超过范围了，需要抛出异常
                if (result < limit + digit) {
                    throw new RuntimeException(s);
                }
                //累减
                result -= digit;
            }
        } else {
            throw new RuntimeException(s);
        }
        //因为这里是累减，所以如果是negative为真的时候直接返回负数，反之返回相反数
        return negative ? result : -result;
    }









    @Test
    public void case7() {
        System.out.println(reverse(-123));
    }

    /**
     * 直接使用string builder的字符串反转方法
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        boolean isLow = x < 0 ? true : false;
        x = Math.abs(x);
        String xString = String.valueOf(x);
        StringBuilder xBuilder = new StringBuilder(xString);
        StringBuilder reverseBuilder = xBuilder.reverse();
        try {
            Integer.parseInt(reverseBuilder.toString());
        } catch (Exception e) {
            return 0;
        }
        return isLow ? -Integer.parseInt(reverseBuilder.toString()) : Integer.parseInt(reverseBuilder.toString());
    }




//    String countNumber = "";
//
//    /**
//     * 递归方法
//     *
//     * @param x
//     * @return
//     */
//    public int reverse(int x) {
//        boolean isLow = x < 0 ? true : false;
//        x = Math.abs(x);
//        reverseFn(x);
//        try {
//            Integer.valueOf(countNumber);
//        } catch (Exception e) {
//            return 0;
//        }
//        return isLow ? -Integer.valueOf(countNumber) : Integer.valueOf(countNumber);
//    }
//
//    public int reverseFn(int x) {
//        countNumber += String.valueOf(x % 10);
//        if (x / 10 == 0) {
//            return x;
//        } else {
//            return reverseFn(x / 10);
//        }
//    }

//    /**
//     * 采用栈解决
//     * @param x
//     * @return
//     */
//    public int reverse(int x) {
//        if (x == 0) {
//            return 0;
//        }
//        boolean isLow = false;
//        if (x < 0) {
//            isLow = true;
//        }
//        x = Math.abs(x);
//
//        Stack<Character> characterStack = new Stack<>();
//        char[] numberChars = String.valueOf(x).toCharArray();
//        for (char numberChar : numberChars) {
//            characterStack.push(numberChar);
//        }
//        String outString = "";
//        int size = characterStack.size();
//        for (int i = 0; i < size; i++) {
//            outString += characterStack.pop();
//        }
//
//        try {
//            Integer.valueOf(outString);
//        } catch (Exception e) {
//            return 0;
//        }
//        return isLow ? -Integer.valueOf(outString) : Integer.valueOf(outString);
//    }
}
