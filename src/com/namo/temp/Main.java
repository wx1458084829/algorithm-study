package com.namo.temp;

import org.junit.Test;

import java.util.*;

/**
 * @author namo
 * @date 2022/3/31-20:19
 */
public class Main {
    @Test
    public void mainTest() {
        System.out.println("这是临时测试代码！");
    }

    @Test
    public void addTest() {
        long a[] = {1, 2, 3};
        long b[] = {4, 5, 6};
        b = addFn(b);
        // 注意运算顺序
        System.out.print(a[1] + a[2] + " " + a[0]);
        System.out.println(b[1] + b[2] + b[0]);
    }

    public long[] addFn(long[] c) {
        c[1] = 100;
        new String();
        String s = new String("s");
        new String();
        return c;
    }


    /**
     * 寻找数组中最大的排列数
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * func lengthOfMaxQueue(nums []int) int {
     * return 0
     * }
     *
     * @param nums int整型ArrayList
     * @return int整型
     */
    public int lengthOfMaxQueue(ArrayList<Integer> nums) {
        return 0;
    }

    @Test
    public void fapai() {
        // 存储108张牌的数组
        int[] total = new int[108];
        // 存储四个玩家的牌
        int[][] player = new int[4][25];
        // 存储当前剩余牌的数量
        int leftNum = 108;
        // 随机数字
        int ranNumber;
        // 随机对象
        Random random = new Random();
        // 初始化数组
        for (int i = 0; i < total.length; i++) {
            total[i] = (i + 1) % 54;
            //处理大小王编号
            if (total[i] == 0) {
                total[i] = 54;
            }
        }
        // 循环发牌
        for (int i = 0; i < 25; i++) {
            //为每个人发牌
            for (int j = 0; j < player.length; j++) {
                //生成随机下标
                ranNumber = random.nextInt(leftNum);
                //发牌
                player[j][i] = total[ranNumber];
                //移动已经发过的牌
                total[ranNumber] = total[leftNum - 1];
                //可发牌的数量减少1
                leftNum--;
            }
        }
        // 循环输出玩家手中的牌
        for (int i = 0; i < player.length; i++) {
            for (int j = 0; j < player[i].length; j++) {
                System.out.print(" " + player[i][j]);
            }
            System.out.println();
        }
        // 底牌
        for (int i = 0; i < 8; i++) {
            System.out.print(" " + total[i]);
        }
        System.out.println();
    }
}
