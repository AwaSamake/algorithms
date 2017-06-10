/**
 *
 *  530. Minimum Absolute Difference in BST
 *    Given a binary search tree with non-negative values, find the minimum absolute 
 *    difference between values of any two nodes.
 *    
 *    Example:
 *    
 *    Input:
 *    
 *       1
 *        \
 *         3
 *        /
 *       2
 *    
 *    Output:
 *    1
 *    
 *    Explanation:
 *    The minimum absolute difference is 1, which is the difference between 2 and 1 (or 
 *    between 2 and 3).
 *    
 */
import java.util.*;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	int min = Integer.MAX_VALUE;
	public int getMinimumDifference(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		int min = Integer.MAX_VALUE;
		int prev = -1;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			TreeNode node = stack.pop();
			root = node.right;
			min = (prev == -1)? min : Math.min(min, node.val - prev);
			prev = node.val;
		}
		return min;
	}
}