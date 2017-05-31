/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/lowest-common-ancestor
@Language: Java
@Datetime: 17-05-30 23:26
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
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return null;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        // both of them found something
        // one on the left, and the other one on the right
        // root is the lowest comment ancestor
        if ((left == A && right == B) || (left == B && right == A)) {
            return root;
        }
        // one side found something
        if (root.val == A.val) {
            return A;
        }
        if (root.val == B.val) {
            return B;
        }
        return left != null ? left : right;
    }
}