package com.namo.exercise;

import com.namo.base.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @author namo
 * @date 2022/6/24-9:15
 */
public class Problem515 {
    @Test
    public void case515() {
        TreeNode node = createNode(new Integer[]{});
        System.out.println(largestValues(node));
    }


    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.isEmpty() == false) {
            Queue<TreeNode> tempQueue = new LinkedList<>();
            tempQueue.addAll(queue);

            int[] a = new int[tempQueue.size()];
            int i = 0;

            while (queue.isEmpty() == false) {
                TreeNode pollNode = queue.poll();
                a[i] = pollNode.val;
                i++;
//               System.out.print(pollNode.val);
            }
            if (a.length > 0) {
                Arrays.sort(a);
            }


            res.add(a[a.length - 1]);


            while (tempQueue.isEmpty() == false) {
                TreeNode pollNode = tempQueue.poll();
                if (pollNode.left != null) {
                    queue.offer(pollNode.left);
                }
                if (pollNode.right != null) {
                    queue.offer(pollNode.right);
                }
            }
        }


        return res;
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
