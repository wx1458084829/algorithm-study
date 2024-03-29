# 官网原题

#### [1282. 用户分组](https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to/)

难度中等61

有 `n` 个人被分成数量未知的组。每个人都被标记为一个从 `0` 到 `n - 1` 的**唯一ID** 。

给定一个整数数组 `groupSizes` ，其中 `groupSizes[i]` 是第 `i` 个人所在的组的大小。例如，如果 `groupSizes[1] = 3` ，则第 `1` 个人必须位于大小为 `3` 的组中。

返回一个组列表，使每个人 `i` 都在一个大小为 *`groupSizes[i]`* 的组中。

每个人应该 **恰好只** 出现在 **一个组** 中，并且每个人必须在一个组中。如果有多个答案，返回其中 **任何** 一个。可以 **保证** 给定输入 **至少有一个** 有效的解。

 

**示例 1：**

```
输入：groupSizes = [3,3,3,3,3,1,3]
输出：[[5],[0,1,2],[3,4,6]]
解释：
第一组是 [5]，大小为 1，groupSizes[5] = 1。
第二组是 [0,1,2]，大小为 3，groupSizes[0] = groupSizes[1] = groupSizes[2] = 3。
第三组是 [3,4,6]，大小为 3，groupSizes[3] = groupSizes[4] = groupSizes[6] = 3。 
其他可能的解决方案有 [[2,1,6],[5],[0,4,3]] 和 [[5],[0,6,2],[4,3,1]]。
```

**示例 2：**

```
输入：groupSizes = [2,1,3,3,3,2]
输出：[[1],[0,5],[2,3,4]]
```

 

**提示：**

- `groupSizes.length == n`
- `1 <= n <= 500`
- `1 <= groupSizes[i] <= n`

通过次数15,007

提交次数18,423

# 个人解法

1. map排序，然后组合返回答案

```java
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
```

# 评论优秀解法

# 题后思考



