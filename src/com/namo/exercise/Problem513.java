package com.namo.exercise;

import org.junit.Test;

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
        return 0;
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


/**
 * 树节点
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

