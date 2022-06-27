package com.namo.temp;

import com.namo.base.ListNode;
import org.junit.Test;

/**
 * @author namo
 * @date 2022/6/27-15:20
 */
public class Temp2 {


    /**
     * 循环单链表结局约瑟夫环问题
     * 间隔数 4
     *输入 1,2,3,4,5,6,7,8  输出6
     */


    @Test
    public void test2() {
        ListNode node = createNode(1, 9);
        while (node.next != null) {
            for (int i = 0; i < Integer.MAX_VALUE - 2; i++) {
                node = node.next;
            }
            deleteNode(node);
            if (node.next != null) {
                node = node.next;
            }
        }
        System.out.println(node.val);
    }

    public ListNode createNode(int start, int end) {

        ListNode listNode = new ListNode(start);
        ListNode head = listNode;
        for (int i = start + 1; i < end; i++) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
        listNode.next = head;
        return head;
    }

    public void deleteNode(ListNode node) {
        ListNode tempNode = null;
        if (node.next.next != null && node.next.next != node) {
            tempNode = node.next.next;
            node.next = tempNode;
        } else {
            node.next = null;
        }
    }
}
