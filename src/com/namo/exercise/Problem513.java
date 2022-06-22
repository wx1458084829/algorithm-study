package com.namo.exercise;

import com.namo.base.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * <p>
 * 假设二叉树中至少有一个节点。
 * <p>
 *  
 * <p>
 * 示例 1:
 * 输入: root = [2,1,3]
 * 输出: 1
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 *  
 * <p>
 * 提示:
 * <p>
 * 二叉树的节点个数的范围是 [1,104]
 * -231 <= Node.val <= 231 - 1 
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-bottom-left-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author namo
 * @date 2022/6/22-0:07
 */
public class Problem513 {


    @Test
    public void case513() {

    }

    /**
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        int leftNumber = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        // 处理单个节点的情况
        leftNumber = root.val;
        while (!nodeQueue.isEmpty()) {
            TreeNode tempNode = nodeQueue.poll();
            if (tempNode.right != null) {
                nodeQueue.offer(tempNode.right);
            }
            // 特殊情况，[1,null,-1] 结果为 -1
            if (tempNode.right != null&&tempNode.left == null){
                leftNumber = tempNode.right.val;
            }
            if (tempNode.left != null) {
                nodeQueue.offer(tempNode.left);
                leftNumber = tempNode.left.val;
            }

        }
        return leftNumber;
    }


    /**
     * 创建树
     *
     * @param nums
     * @return
     */
    public TreeNode createTreeNode(int[] nums) {
        return null;
    }

    /**
     * 遍历树，最好是结构显示
     */


}

