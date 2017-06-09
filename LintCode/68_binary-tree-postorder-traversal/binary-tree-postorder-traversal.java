/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/binary-tree-postorder-traversal
@Language: Java
@Datetime: 17-06-08 22:56
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
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> values = new ArrayList<Integer>();
        postorderTraversal(root, values);
        return values;
    }
    
    public void postorderTraversal(TreeNode root, ArrayList<Integer> values) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left, values);
        postorderTraversal(root.right, values);
        values.add(root.val);
    }
}