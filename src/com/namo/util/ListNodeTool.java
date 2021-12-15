package com.namo.util;

import com.namo.base.ListNode;

public class ListNodeTool {
    /**
     * 数组转换成链表
     *
     * @param arr 数组
     * @return 返回对应带头节点的链表
     */
    public static ListNode covertArr2LinkedList(int[] arr) {
        ListNode head = new ListNode();
        ListNode tag = head;
        for (int i = 0; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i]);
            temp.next = null;
            tag.next = temp;
            tag = tag.next;
        }
        return head;
    }

    /**
     * 输出带头节点链表带内容
     *
     * @param head
     */
    public static void showLinkedList(ListNode head) {
        while (head.next != null) {
            head = head.next;
            System.out.print(head.val + " ");
        }
        System.out.println("end");
    }
}
