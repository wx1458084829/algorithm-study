package com.namo.practice19;

import com.namo.base.ListNode;
import com.namo.util.ListNodeTool;
import org.junit.Test;

public class Solution {
    @Test
    public void removeNthFromEndTest() {
        ListNode listNode = ListNodeTool.covertArr2LinkedList(new int[]{1, 2, 3, 4, 5, 6});
        this.removeNthFromEnd(listNode, 4);
        ListNodeTool.showLinkedList(listNode);
    }

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


    // TODO 19递归解法
    // TODO 19基本解法
//    /**
//     *
//     * @param head
//     * @param n
//     * @return
//     */
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        int index = removeNthFromEndReduce(head, n);
//        System.out.println(index);
//        if (index == -1) {
//            return head;
//        } else {
//            return head.next;
//        }
//    }
//
//    public static int removeNthFromEndReduce(ListNode listNode, int n) {
//        if (listNode == null) {
//            return 0;
//        } else {
//            int temp = removeNthFromEndReduce(listNode.next, n) + 1;
//            if (temp == n - 1) {
//                listNode.next = listNode.next.next;
//                return -1;
//            }
//            return temp;
//        }
//    }


}