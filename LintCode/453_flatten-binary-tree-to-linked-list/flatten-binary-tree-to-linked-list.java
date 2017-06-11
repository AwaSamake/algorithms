/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/flatten-binary-tree-to-linked-list
@Language: Java
@Datetime: 17-06-10 23:52
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
    class HeadTail {
        TreeNode head, tail;
        public HeadTail() {
            head = null;
            tail = null;
        }
        
        public HeadTail(TreeNode head, TreeNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        flattenHelper(root);
    }
    
    public HeadTail flattenHelper(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        HeadTail left = flattenHelper(root.left);
        HeadTail right = flattenHelper(root.right);
        if (left == null && right == null) {
            return new HeadTail(root, root);
        }
        if (left == null) {
            return new HeadTail(root, right.tail);
        }
        if (right == null) {
            root.right = left.head;
            root.left = null;
            return new HeadTail(root, left.tail);
        }
        left.tail.right = right.head;
        root.right = left.head;
        root.left = null;
        return new HeadTail(root, right.tail);
    }
}