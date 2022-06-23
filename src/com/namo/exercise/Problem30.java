package com.namo.exercise;

import org.junit.Test;

import java.util.*;

/**
 * @author namo
 * @date 2022/6/23-9:10
 */
public class Problem30 {
    @Test
    public void case30() {
        List<Integer> barfoothefoobarman = findSubstring("thefoobarman", new String[]{"bar", "foo", "the"});
        System.out.println(barfoothefoobarman);
    }

    /**
     * 采用滑动窗口算法解决问题
     * 存储字符串采用Map存储
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> tempNum = new HashMap<>();
        for (String word : words) {
            if (tempNum.get(word) == null) {
                tempNum.put(word, 1);
            } else {
                tempNum.put(word, tempNum.get(word) + 1);
            }
        }

        char[] sChars = s.toCharArray();
        for (int i = 0; i < sChars.length - (words[0].length() * words.length) + 1; i++) {
            Map<String, Integer> numMap = new HashMap<>();
            numMap.putAll(tempNum);
            char[] windowChars = Arrays.copyOfRange(sChars, i, i + (words[0].length() * words.length));
            String windowString = String.valueOf(windowChars);
            for (int j = 0; j < windowString.length(); j = j + words[0].length()) {
                String tempSubString = windowString.substring(j, j + words[0].length());
                if (numMap.get(tempSubString) == null) {
                    break;
                }
                Integer subCount = numMap.get(tempSubString);
                subCount = subCount - 1;

                if (subCount == 0) {
                    numMap.remove(tempSubString);
                } else {
                    numMap.put(tempSubString, subCount);
                }
            }
            if (numMap.isEmpty() == true) {
                res.add(i);
            }
        }
        return res;
    }


//    /**
//     * 有bug
//     * @param s
//     * @param words
//     * @return
//     */
//    public List<Integer> findSubstring(String s, String[] words) {
//        List<Integer> res= new ArrayList<>();
//        String wordsString = "";
//        for (String word : words) {
//            wordsString += word;
//        }
//        char[] wordsChars = wordsString.toCharArray();
//        char[] sChars = s.toCharArray();
//        for (int i = 0; i < sChars.length - wordsChars.length + 1; i++) {
//            System.out.println(Arrays.copyOfRange(sChars, i, i + wordsChars.length));
//            //
//            boolean sub = isSub(Arrays.copyOfRange(sChars, i, i + wordsChars.length), wordsChars);
//            if (sub){
//                res.add(i);
//            }
//        }
//        return res;
//    }
//
//    private boolean isSub(char[] ch1, char[] ch2) {
////        Map<Character, Integer> tempMap = new HashMap<>();
//        int count = 0;
//        for (int i = 0; i < ch1.length; i++) {
//            count += (ch1[i] - ch2[i]);
//        }
//        return count == 0 ? true : false;
//    }


    private void perm(char[] chars, int begin, TreeSet<String> treeSet) {
        if (chars == null || chars.length == 0 || begin > chars.length - 1) {
            return;
        }
        if (begin == chars.length - 1) {
            treeSet.add(String.valueOf(chars));
            return;
        }
        for (int i = begin; i < chars.length; i++) {
            swap(chars, begin, i);
            perm(chars, begin + 1, treeSet);
            swap(chars, begin, i);
        }
    }

    @Test
    public void testA() {
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
