/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/validate-binary-search-tree
@Language: Java
@Datetime: 17-05-31 05:05
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
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Integer lower = null, upper = null;
        return isValidBST(root, lower, upper);
    }
    
    private boolean isValidBST(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        
        if ((lower != null && root.val <= lower) || (upper != null && root.val >= upper)) {
            return false;
        }
        
        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }
}