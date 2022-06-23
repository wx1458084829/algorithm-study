package com.namo.exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author namo
 * @date 2022/6/23-9:10
 */
public class Problem30 {
    @Test
    public void case30() {
        String a = "123";
        String b = "23";
        int i = a.indexOf(b);
        System.out.println(i);
    }


    public List<Integer> findSubstring(String s, String[] words) {


        return null;
    }

    private void perm(char[] chars, int begin, TreeSet<String> treeSet) {
        if (chars == null || chars.length == 0 || begin > chars.length-1) {
            return;
        }
        if (begin == chars.length-1) {
            treeSet.add(String.valueOf(chars));
            return;
        }
        for (int i = begin; i < chars.length; i++) {
            swap(chars, begin, i);
            perm(chars, begin+1, treeSet);
            swap(chars, begin, i);
        }
    }

    @Test
    public void testA(){
        List<String> list = findPermutation("absadasdasda");
        System.out.println(list);
    }

    /**
     * 求string字符串的所有全排列，比如：字符串abc,他的全排列为 abc、acb、bac、bca、cab、cba
     * 比如：
     * 力扣46题：https://leetcode-cn.com/problems/permutations/submissions/
     * 力扣47题：https://leetcode-cn.com/problems/permutations-ii/
     */
    public static List<String> findPermutation(String str) {
        // 特殊情况特殊处理
        if (str == null || str.length() < 1) {
            return null;
        }
        List<String> resultList = new ArrayList<>();
        process(str.toCharArray(), 0, resultList);
        return resultList;
    }

    /**
     * @param chars   字符数组
     * @param index   当前来到的位置
     * @param resList 结果集合（将结果收集到这个list里）
     */
    public static void process(char[] chars, int index, List<String> resList) {
        // base case
        if (index == chars.length) {
            // index超过数组最后一个位置时【开始结算】（因为后面已经没有可用选择了）
            resList.add(new String(chars));
            return;
        }
        // 利用缓存来剪枝（由于str只由26个小写字母组成，所以这里开一个长度为26的数组就够表示了），【这里也可以用hashSet来剪枝，原理一样】
        int[] visited = new int[26];
        // i后面的每个位置的字符，都可以来到index位置
        for (int i = index; i < chars.length; i++) {
            int position = chars[i] - 'a';
            // 【之前】有【和i位置的字符】相同的字符被交换到index位置过(那就不用交换，直接看 i + 1位置的数)
            if (visited[position] != 0) {
                continue;
            }
            // 记录上，i位置的字符被交换到index位置过了
            visited[position] = 1;
            // 将i位置和index位置进行交换
            swap(chars, i, index);
            // 处理index + 1后面的位置，看看当index位置是i位置的字符时，后面的位置还有多少种可能（子问题）
            process(chars, index + 1, resList);
            // 每交换完一个位置后，进行第二轮交换时需要将上一轮交换的位置给换回来
            swap(chars, i, index);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
