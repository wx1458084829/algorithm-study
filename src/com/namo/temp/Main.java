package com.namo.temp;

import org.junit.Test;

/**
 * @author namo
 * @date 2022/3/31-20:19
 */
public class Main {
    @Test
    public void mainTest(){
        System.out.println("这是临时测试代码！");
    }
    @Test
    public void addTest(){
        long a[] = {1,2,3};
        long b[] = {4,5,6};
        b = addFn(b);
        // 注意运算顺序
        System.out.print(a[0]+a[1]+a[2]+" ");
        System.out.println(b[0]+b[1]+b[2]);
    }

    public long[] addFn(long[] c){
        c[1] = 100;
        return c;
    }
}
