package com.namo.exercise;

import com.namo.base.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author namo
 * @date 2022/6/22-15:03
 * TODO 未解决
 */
public class Problem98 {
    @Test
    public void case98() {
        TreeNode node = createNode(new Integer[]{5,4,6,null,null,3,7});
        boolean validBST = isValidBST(node);
        System.out.println(validBST);
    }

    /**
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            if (tempNode.left != null && tempNode.left.val >= tempNode.val) {
                return false;
            } else if (tempNode.right != null && tempNode.val >= tempNode.right.val) {
                return false;
            }
            if (tempNode.left != null) {
                queue.offer(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.offer(tempNode.right);
            }
        }
        return true;
    }


    /**
     * 创建二叉树 ？可能有问题
     *
     * @param a
     * @return
     */
    public TreeNode createNode(Integer[] a) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        TreeNode root = new TreeNode(a[0]);
        nodeQueue.offer(root);
        for (int i = 1; i < a.length; ) {
            TreeNode tempNode = nodeQueue.poll();
            if (a[i] != null) {
                tempNode.left = new TreeNode(a[i]);
                nodeQueue.offer(tempNode.left);
            }
            i++;
            if (i < a.length && a[i] != null) {
                tempNode.right = new TreeNode(a[i]);
                nodeQueue.offer(tempNode.right);
            }
            i++;
        }
        return root;
    }

}
