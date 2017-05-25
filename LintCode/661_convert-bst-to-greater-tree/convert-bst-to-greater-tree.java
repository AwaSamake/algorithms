/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/convert-bst-to-greater-tree
@Language: Java
@Datetime: 17-05-25 00:42
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
     * @param root the root of binary tree
     * @return the new root
     */
    public TreeNode convertBST(TreeNode root) {
        convertBST(root, 0);
        return root;
    }
    
    private int convertBST(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        
        int right = convertBST(root.right, sum);
        root.val += right;
        int left = convertBST(root.left, root.val);
        return left;
    }
}