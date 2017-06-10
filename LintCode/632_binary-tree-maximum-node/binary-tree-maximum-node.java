/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/binary-tree-maximum-node
@Language: Java
@Datetime: 17-06-10 01:54
*/

public class Solution {
    /**
     * @param root the root of binary tree
     * @return the max ndoe
     */
    public TreeNode maxNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = maxNode(root.left);
        TreeNode right = maxNode(root.right);
        if (left != null && left.val > root.val) {
            root = left;
        } 
        if (right != null && right.val > root.val) {
            root = right;
        } 
        return root;
    }
}