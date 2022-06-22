package com.namo.tree;

import com.namo.base.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author namo
 * @date 2022/6/22-10:08
 */
public class TreeDemo {
    @Test
    public void testNode() {
        Integer[] a = new Integer[]{1, 2, 3, 4, null, 5, 6, null, null, 7};
//        Integer[] a = new Integer[]{2,1,3};

        TreeNode node = createNode(a);

    }

    /**
     * 创建二叉树 ？可能有问题
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
