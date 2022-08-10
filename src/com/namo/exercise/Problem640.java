package com.namo.exercise;

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
        System.out.println(s);
    }
    @Test
    public void test2() {
        String s = solveEquation("x=x");
        System.out.println(s);
    }
    @Test
    public void test3() {
        String s = solveEquation("2x=x");
        System.out.println(s);
    }

    @Test
    public void test4(){
        String s = "+2x+5-3+x";
        //(\+([1-9])?(x)?)|(-([1-9])?(x)?)
        Pattern pattern = Pattern.compile("(\\+|-)([1-9])?(x)?",Pattern.UNICODE_CASE);
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            // 找到匹配内容，进行后续事情
            String strAid = matcher.group();
            System.out.println(strAid);
        }
//        System.out.println(Arrays.toString(s.split("[\\+,-]")));


    }

    public String solveEquation(String equation) {
        int equalIndex = equation.indexOf("=");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(equation.substring(0, equalIndex));
        stringBuffer.reverse();
        stringBuffer.append("+");
        stringBuffer.reverse();
        char[] leftEquation = stringBuffer.toString().toCharArray();
        stringBuffer.delete(0, stringBuffer.length());

        stringBuffer.append(equation.substring(equalIndex + 1, equation.length()));
        stringBuffer.reverse();
        stringBuffer.append("+");
        stringBuffer.reverse();
        char[] rightEquation = stringBuffer.toString().toCharArray();

        int xSymbol = 0;
        int rightSymbol = 0;

        System.out.println(leftEquation);
        System.out.println(rightEquation);

        for (int i = 0; i < leftEquation.length; i=i+2) {
            if (leftEquation[i+1] == 'x') {
                if (leftEquation[i] == '+'){
                    xSymbol+=1;
                }else {
                    xSymbol-=1;
                }
            } else  {
                if (leftEquation[i] == '+'){
                    rightSymbol-=new Integer(leftEquation[i+1]);
                }else {
                    rightSymbol+=new Integer(leftEquation[i+1]);
                }
            }
        }

        for (int i = 0; i < rightEquation.length; i=i+2) {
            if (rightEquation[i+1] == 'x') {
                if (rightEquation[i] == '+'){
                    xSymbol-=1;
                }else {
                    xSymbol+=1;
                }
            } else  {
                if (rightEquation[i] == '+'){
                    rightSymbol+=new Integer(rightEquation[i+1]);
                }else {
                    rightSymbol-=new Integer(rightEquation[i+1]);
                }
            }
        }

        if (xSymbol == 0){
            return "Infinite solutions";
        }
        return String.valueOf((int)rightSymbol/xSymbol);
    }
}
