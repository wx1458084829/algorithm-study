package com.namo.util;

import com.namo.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeTool {
    /**
     * 创建树
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
}
