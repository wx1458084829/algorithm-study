package com.namo.exercise;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author namo
 * @date 2022/8/10-11:14
 */
public class Problem640 {

    @Test
    public void test1() {
        String s = solveEquation("x+5-3+x=6+x-2");
        String res = "x=2";
        Assert.assertEquals(s,res);
        System.out.println(s);
    }

    @Test
    public void test2() {
        String s = solveEquation("x=x");
        String res = "Infinite solutions";
        Assert.assertEquals(s,res);
        System.out.println(s);
    }

    @Test
    public void test3() {
        String s = solveEquation("2x=x");
        String res = "x=0";
        Assert.assertEquals(s,res);
        System.out.println(s);
    }

    @Test
    public void test4() {
        String s = solveEquation("-x=-1");
        String res = "x=1";
        Assert.assertEquals(s,res);
        System.out.println(s);
    }

    @Test
    public void test5() {
        String s = solveEquation("-x=1");
        String res = "x=-1";
        Assert.assertEquals(s,res);
        System.out.println(s);
    }


    @Test
    @Ignore
    public void myTest() {
        String s = "+2000x+5-3+x";
        //(\+([1-9])?(x)?)|(-([1-9])?(x)?)
        Pattern pattern = Pattern.compile("(\\+|-)([0-9]){0,100}(x)?", Pattern.UNICODE_CASE);
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            // 找到匹配内容，进行后续事情
            String strAid = matcher.group();
            System.out.println(strAid);
        }
//        System.out.println(Arrays.toString(s.split("[\\+,-]")));


    }

    /**
     * 640. 求解方程
     *
     * @param equation
     * @return
     */
    public String solveEquation(String equation) {
        int xSymbol = 0;
        int rightSymbol = 0;
//        获取分割字符'='的位置
        int equalIndex = equation.indexOf("=");
//        左表达式字符串
        StringBuffer leftStr = new StringBuffer(equation.substring(0, equalIndex));
//        特殊情况，当表达式为x=2这种情况下需要手动加上+，即+x=2，以便和-x=2这种情况一样，便于进行一般化处理
        if (leftStr.charAt(0) != '-') {
            leftStr.reverse();
            leftStr.append("+");
            leftStr.reverse();
        }
        StringBuffer rightStr = new StringBuffer(equation.substring(equalIndex + 1, equation.length()));
        if (rightStr.charAt(0) != '-') {
            rightStr.reverse();
            rightStr.append("+");
            rightStr.reverse();
        }
//        正则表达式匹配规则
        String regexStr = "(\\+|-)([0-9]){0,100}(x)?";
        Pattern pattern = Pattern.compile(regexStr);
//        左匹配
        Matcher leftMatcher = pattern.matcher(leftStr);
        while (leftMatcher.find()) {
//            获得匹配结果
            String strItem = leftMatcher.group();
//            判断是系数还是值
            if (strItem.indexOf("x") == -1) {
//                判断正负值
                if (strItem.indexOf("+") == -1) {
                    rightSymbol += new Integer(strItem.substring(1));
                } else {
                    rightSymbol -= new Integer(strItem.substring(1));
                }
            } else {
                if (strItem.indexOf("+") == -1) {
                    if (strItem.length() == 2) {
                        xSymbol -= 1;
                    } else {
                        xSymbol -= new Integer(strItem.substring(1, strItem.length() - 1));
                    }

                } else {
                    if (strItem.length() == 2) {
                        xSymbol += 1;
                    } else {
                        xSymbol += new Integer(strItem.substring(1, strItem.length() - 1));
                    }
                }
            }
        }

        Matcher rightMatcher = pattern.matcher(rightStr);
        while (rightMatcher.find()) {
            String strItem = rightMatcher.group();
            if (strItem.indexOf("x") == -1) {
                if (strItem.indexOf("+") == -1) {
                    rightSymbol -= new Integer(strItem.substring(1));
                } else {
                    rightSymbol += new Integer(strItem.substring(1));
                }
            } else {
                if (strItem.indexOf("+") == -1) {
                    if (strItem.length() == 2) {
                        xSymbol += 1;
                    } else {
                        xSymbol += new Integer(strItem.substring(1, strItem.length() - 1));
                    }

                } else {
                    if (strItem.length() == 2) {
                        xSymbol -= 1;
                    } else {
                        xSymbol -= new Integer(strItem.substring(1, strItem.length() - 1));
                    }
                }
            }
        }
//        左右均为0，说明有无限解
        if (xSymbol == 0 && rightSymbol == 0) {
            return "Infinite solutions";
        }
//        x为0，说明无解
        if (xSymbol == 0) {
            return "No solution";
        }
//        构造返回
        return "x=" + String.valueOf((int) rightSymbol / xSymbol);
    }
}
