/**
 *
 *  513. Find Bottom Left Tree Value
 *    Given a binary tree, find the leftmost value in the last row of the tree.
 *    
 *    Example 1:
 *    Input:
 *    
 *        2
 *       / \
 *      1   3
 *    
 *    Output:
 *    1
 *    Example 2: 
 *    Input:
 *    
 *            1
 *           / \
 *          2   3
 *         /   / \
 *        4   5   6
 *           /
 *          7
 *    
 *    Output:
 *    7
 *    Note: You may assume the tree (i.e., the given root node) is not NULL.
 *
 */
import java.util.*;

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
	public int findBottomLeftValue(TreeNode root) {
		if (root == null) {
			return -1;
		}
		List<Integer> values = new ArrayList<Integer>();
		findBottomLeftValue(root, values, 1);
		return values.remove(values.size() - 1);
	}
	
	public void findBottomLeftValue(TreeNode root, List<Integer> values, int level) {
		if (values.size() < level) {
			values.add(root.val);
		}
		if (root.left != null) {
			findBottomLeftValue(root.left, values, level + 1);
		}
		if (root.right != null) {
			findBottomLeftValue(root.right, values, level + 1);
		}
	}
}