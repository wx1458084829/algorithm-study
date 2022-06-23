# 官网原题

#### [30. 串联所有单词的子串](https://leetcode.cn/problems/substring-with-concatenation-of-all-words/)

难度 `困难`

给定一个字符串 `s` 和一些 **长度相同** 的单词 `words` **。**找出 `s` 中恰好可以由 `words` 中所有单词串联形成的子串的起始位置。

注意子串要与 `words` 中的单词完全匹配，**中间不能有其他字符** ，但不需要考虑 `words` 中单词串联的顺序。

 

**示例 1：**

```
输入：s = "barfoothefoobarman", words = ["foo","bar"]
输出：[0,9]
解释：
从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
输出的顺序不重要, [9,0] 也是有效答案。
```

**示例 2：**

```
输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
输出：[]
```

**示例 3：**

```
输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
输出：[6,9,12]
```

 

**提示：**

- `1 <= s.length <= 104`
- `s` 由小写英文字母组成
- `1 <= words.length <= 5000`
- `1 <= words[i].length <= 30`
- `words[i]` 由小写英文字母组成



# 个人解法

````java
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
````

> 采用滑动窗口算法去解决问题。
>
> 1. 设置窗口大小为words里面所有字符串的长度之和。
> 2. 滑动过程中使用Map<String,Integer>的数据结构存储出现单个word次数。
> 3. 计算每次滑动的窗口是否符合要求，即每个word在窗口里面出现的次数是不是满足题意，如果符合就记录

# 评论优秀解法

# 题后思考





* ~~滑动窗口算法~~

* 回溯算法
* 求全排列
  * 递归
  * 动态规划



