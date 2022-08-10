package com.namo.exercise;

/**
 * 1374. 生成每种字符都是奇数个的字符串
 * @author namo
 * @date 2022/8/10-18:45
 */
public class Problem1374 {
    public String generateTheString(int n) {
        StringBuffer stringBuffer = new StringBuffer();
        if (n%2  ==  1){
            for (int i = 0; i < n; i++) {
                stringBuffer.append('a');
            }
        }else {
            for (int i = 0; i < n-1; i++) {
                stringBuffer.append('a');
            }
            stringBuffer.append("b");
        }
        return stringBuffer.toString();
    }
}
