# 官网原题

#### [1413. 逐步求和得到正数的最小值](https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum/)

难度简单81收藏分享切换为英文接收动态反馈

给你一个整数数组 `nums` 。你可以选定任意的 **正数** startValue 作为初始值。

你需要从左到右遍历 `nums` 数组，并将 startValue 依次累加上 `nums` 数组中的值。

请你在确保累加和始终大于等于 1 的前提下，选出一个最小的 **正数** 作为 startValue 。

 

**示例 1：**

```
输入：nums = [-3,2,-3,4,2]
输出：5
解释：如果你选择 startValue = 4，在第三次累加时，和小于 1 。
                累加求和
                startValue = 4 | startValue = 5 | nums
                  (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
                  (1 +2 ) = 3  | (2 +2 ) = 4    |   2
                  (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
                  (0 +4 ) = 4  | (1 +4 ) = 5    |   4
                  (4 +2 ) = 6  | (5 +2 ) = 7    |   2
```

**示例 2：**

```
输入：nums = [1,2]
输出：1
解释：最小的 startValue 需要是正数。
```

**示例 3：**

```
输入：nums = [1,-2,-3]
输出：5
```

**提示：**

- `1 <= nums.length <= 100`
- `-100 <= nums[i] <= 100`

# 个人解法

1. 思想：采用正向计算，以1位初始值（因为要求大小始终要大于1），如果为是负数，那么就取绝对值然后相加到变量`startValue`里面,如果为正数就需要减去这个正数的值，最后需要比较`maxValue`和`startValue`的大小，取最值（因为如果后续是正数，`startValue`会被越减越小的，故取最大值）。

   代码：

   ````java
       public int minStartValue(int[] nums) {
           int startValue = 1;
           int maxValue = 1;
           for (int item : nums) {
               if (item > 0) {
                   startValue -= item;
               } else {
                   startValue += Math.abs(item);
               }
               if (startValue > maxValue) {
                   maxValue = startValue;
               }
           }
           return maxValue;
       }
   ````

   

# 评论优秀解法

# 题后思考



