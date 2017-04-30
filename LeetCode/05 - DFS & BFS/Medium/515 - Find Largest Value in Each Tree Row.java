/**
 *
 *  515. Find Largest Value in Each Tree Row
 *    You need to find the largest value in each row of a binary tree.
 *    
 *    Example:
 *    Input: 
 *    
 *              1
 *             / \
 *            3   2
 *           / \   \  
 *          5   3   9 
 *    
 *    Output: [1, 3, 9]
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
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> values = new ArrayList<Integer>();
		if (root == null) {
			return values;
		}
		largestValues(root, values, 1);
		return values;
	}
	
	public void largestValues(TreeNode root, List<Integer> values, int level) {
		if (values.size() < level) {
			values.add(root.val);
		}
		if (values.get(level - 1) < root.val) {
			values.set(level - 1, root.val);
		}
		if (root.left != null) {
			largestValues(root.left, values, level + 1);
		}
		if (root.right != null) {
			largestValues(root.right, values, level + 1);
		}
	}
}