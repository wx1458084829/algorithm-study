package com.namo.other;

import com.namo.base.ListNode;

public class Solution {


    /**
     * 合并两个有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        ListNode tempNode = listNode;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    tempNode.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    tempNode.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
                tempNode = tempNode.next;
            } else if (l1 == null) {
                tempNode.next = new ListNode(l2.val);
                tempNode = tempNode.next;
                l2 = l2.next;
            } else if (l2 == null) {
                tempNode.next = new ListNode(l1.val);
                tempNode = tempNode.next;
                l1 = l1.next;
            }
        }
        return listNode.next;
    }
}
