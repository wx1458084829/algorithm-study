# algorithm-study

## 时间复杂度



## 空间复杂度





主定律



常见且不熟悉



反馈：看别人的解法



先思考解法，选择最优 



# 链表

链表是改善数组的插入和删除

未知数据量

## 单链表

### 删除倒数第k个节点

- **双指针解法或者快慢指针**

实质上类似于做了一个减法，我们设从后往前数为倒序号，从前往后为正序号，那么 `倒序号(1为起始下标)+正序号(1为起始下标)-1=总长度` ，由此公式可得：

1. fast指针首先移动k个位置。
2. slow指针和fast指针也一起移动，移动的基准为fast指针到底。
3. 那么slow指针就刚好到我们要删除的元素的前一个位置。
4. 以slow为基准，执行链表删除操作即可。

> 由于链表具有头节点，那么上面的公式不应该减一，相当于正序号是从0开始的。

![请添加图片描述](https://img-blog.csdnimg.cn/7016574c6d9a4a44988bc3f5a955e3fb.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAd3gxNDU4MDg0ODI5,size_20,color_FFFFFF,t_70,g_se,x_16)

**代码如下：**

````java
		/**
     * 19. 删除链表的倒数第 N 个结点
     * 删除链表的倒数第N个节点(双指针，即快慢指针)
     * 注意：考虑删除的位置
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        //fast移n步，目的是为了判断删除的位置
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        //如果fast为空，表示删除的是头结点
        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //当前slow为要删除的第k个节点第前一个节点
        slow.next = slow.next.next;
        return head;
    }
````

- **栈解法**

* **直观长度解法**

 		求的长度，再利用公式相减得到第二次前进的距离

### 合并两个有序链表

### 回文链表

### 反转链表

### 反转相邻节点链表

### 判断链表是否有环

**利用set **

**快慢指针**

## 循环链表

## 双向链表



# 树

前序遍历：父节点-左节点-右节点

后序遍历：左节点-右节点-父节点

中序遍历：左节点-父节点-右节点



> 遍历顺序是以父节点而言 ，左右子节点都是按照左右的顺序





分治算法

