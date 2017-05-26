/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/search-range-in-binary-search-tree
@Language: Java
@Datetime: 17-05-26 05:03
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
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> keys = new ArrayList<Integer>();
        if (root == null) {
            return keys;
        }
        
        while (root != null && root.val > k2) {
            root = root.left;
        }
        while (root != null && root.val < k1) {
            root = root.right;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                if (root.val >= k1 && root.val <= k2) {
                    keys.add(root.val);
                }
                root = root.right;
            }
        }
        return keys;
    }
}