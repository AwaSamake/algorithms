/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/remove-node-in-binary-search-tree
@Language: Java
@Datetime: 17-05-24 23:14
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
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        if (root == null) {
            return root;
        }
        
        // go to right or left
        if (root.val < value) {
            root.right = removeNode(root.right, value);
            return root;
        } else if (root.val > value) {
            root.left = removeNode(root.left, value);
            return root;
        }
        
        // return left subtree as reset
        if (root.right == null) {
            return root.left;
        }
        // return right subtree as reset
        if (root.left == null) {
            return root.right;
        }
        
        if (root.right.left == null) {
            return root.right;
        }
        
        TreeNode leftMostNode = leftMostNode(root.right);
        root.val = leftMostNode.val;
        return root;
    }
    
    private TreeNode leftMostNode(TreeNode root) {
        while (root.left != null && root.left.left != null) {
            root = root.left;
        }
        TreeNode node = root.left;
        root.left = root.left.right;
        return node;
    }
}