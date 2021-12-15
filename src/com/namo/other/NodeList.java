package com.namo.other;

import com.namo.base.ListNode;

public class NodeList {


    static int a = 0;


//    public int length(ListNode node, int n) {
//        if (node == null)
//            return 0;
//        int pos = length(node.next, n) + 1;
//        //获取要删除链表的前一个结点，就可以完成链表的删除
//        if (pos == n + 1)
//            node.next = node.next.next;
//        return pos;
//    }


    public static int tt(ListNode listNode,int n) {
        if (listNode == null) {
            return 0;
        } else {
            int temp = tt(listNode.next,n)+1;
            if (temp == n){
                System.out.println(listNode.val);
            }
            return temp;
        }
    }


//    public static void tt(ListNode listNode) {
//        if (listNode == null) {
//            return;
//        } else {
//            a++;
//            //顺序决定前后的顺序（逆序）
//            tt(listNode.next);
//            System.out.println(listNode.val);
//
////            //顺序决定前后的顺序（顺序）
////            System.out.println(listNode.val);
////            tt(listNode.next);
//        }
//    }

    //求链表的长度
    private int length(ListNode head) {
        if (head == null)
            return 0;
        return length(head.next) + 1;
    }

}
