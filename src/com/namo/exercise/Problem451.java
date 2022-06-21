package com.namo.exercise;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
 * <p>
 * 返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "tree"
 * 输出: "eert"
 * 解释: 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 * <p>
 * 输入: s = "cccaaa"
 * 输出: "cccaaa"
 * 解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 * <p>
 * 输入: s = "Aabb"
 * 输出: "bbAa"
 * 解释: 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 5 * 105
 * s 由大小写英文字母和数字组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sort-characters-by-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author namo
 * @date 2022/6/21-10:41
 */
public class Problem451 {

    @Test
    public void Case451(){
        frequencySort("Aabb");
    }

    /**
     * 基本采用map解决
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> characterIntegerMap = new TreeMap<>();

        for (char item : chars) {
            if (characterIntegerMap.get(item) == null) {
                characterIntegerMap.put(item, 1);
            } else {
                Integer tempInt = characterIntegerMap.get(item);
                tempInt++;
                characterIntegerMap.put(item, tempInt);
            }
        }

        // 将这个map转换成list以便排序
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(characterIntegerMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            // 默认的是从小到大排序，
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                // 从大到小排序
                 return (o2.getValue() - o1.getValue());
                // 从小到大排序
//                return (o1.getValue() - o2.getValue());
            }
        });

        StringBuilder sb = new StringBuilder();

// 输出排序后的结果
        for (Map.Entry<Character, Integer> t : list) {

            for (int i = 0; i < t.getValue(); i++) {
                sb.append(t.getKey());
            }

//            System.out.println(t.getKey() + ":" + t.getValue());
        }
        return sb.toString();
    }
    //todo 题解解决方案
}
