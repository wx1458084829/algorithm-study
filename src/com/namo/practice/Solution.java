package com.namo.practice;

import org.junit.Test;

import java.util.*;

public class Solution {

    @Test
    public void treeTest() {
        Integer[] ins = new Integer[]{};
        TreeNode root = covertArr2Tree(ins);
        List<Integer> integers = this.inorderTraversal(root);
        System.out.println(integers);
    }

    /**
     * 创建树
     *
     * @param treeArr
     * @return
     */
    public static TreeNode covertArr2Tree(Integer[] treeArr) {
        //设置根节点
        TreeNode root = null;
        //队列
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //创建根节点
        if (treeArr.length > 0) {
            root = new TreeNode(treeArr[0]);
            queue.offer(root);
        }
        for (int i = 1; i < treeArr.length; i++) {
            //节点为空则向后移动
            if (treeArr[i] == null) {
                continue;
            }
            TreeNode peekNode = queue.peek();
            //设置左右节点数据， i % 2 是每个左节点的序号都是奇数（从0开始）
            if (peekNode.left == null && i % 2 == 1) {
                TreeNode left = new TreeNode(treeArr[i]);
                peekNode.left = left;
                queue.offer(left);
            } else if (peekNode.right == null && i % 2 == 0) {
                TreeNode right = new TreeNode(treeArr[i]);
                peekNode.right = right;
                queue.offer(right);
                //右节点填充完成，出队列
                queue.poll();
            }
        }
        return root;
    }


    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }
        return list;
    }


    @Test
    public void removeNthFromEndTest() {
        ListNode listNode = covertArr2LinkedList(new int[]{1, 2, 3, 4, 5, 6});
        this.removeNthFromEnd(listNode, 4);
        showLinkedList(listNode);
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


    @Test
    public void testMergeTwoLists() {
        ListNode listNode = covertArr2LinkedList(new int[]{1, 2, 3, 4, 5});
        showLinkedList(listNode);
    }


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
