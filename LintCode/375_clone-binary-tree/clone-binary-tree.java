/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/clone-binary-tree
@Language: Java
@Datetime: 17-05-30 23:00
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree
     * @return root of new tree
     */
    public TreeNode cloneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode dup = new TreeNode(root.val);
        dup.left = cloneTree(root.left);
        dup.right = cloneTree(root.right);
        return dup;
    }
}