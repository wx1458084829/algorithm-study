package com.namo.exercise;

import org.junit.Test;

import java.util.*;

/**
 * @author namo
 * @date 2022/8/12-0:10
 */
public class Problem1282 {
    @Test
    public void test1() {
        List<List<Integer>> lists = groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3});
        System.out.println(lists);
    }


    /**
     * 1282. 用户分组
     * @param groupSizes
     * @return
     */
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, Integer> groupMap = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            groupMap.put(i, groupSizes[i]);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(groupMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            // 默认的是从小到大排序，
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o1.getValue() - o2.getValue());
            }
        });

        List<List<Integer>> res = new ArrayList<>();

        List<Integer> tempList = null;
        for (Map.Entry<Integer, Integer> t : list) {
            if (t.getValue() <= 1) {
                tempList = new ArrayList<>();
                tempList.add(t.getKey());
                res.add(tempList);
                tempList = null;
                continue;
            }
            if (tempList == null) {
                tempList = new ArrayList<>();
                tempList.add(t.getKey());
            } else if (tempList.size() < t.getValue() - 1) {
                tempList.add(t.getKey());
            } else {
                tempList.add(t.getKey());
                res.add(tempList);
                tempList = null;
            }
        }
        return res;
    }
}
