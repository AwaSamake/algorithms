/**
 *
 *  222. Count Complete Tree Nodes
 *    Given a complete binary tree, count the number of nodes.
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
	public int countNodes(TreeNode root) {
		int count = 0, height = getHeight(root);
		
		while (root != null) {
			if (getHeight(root.right) == height - 1) {
				root = root.right;
				count += 1 << height;
			} else {
				root = root.left;
				count += 1 << height - 1;
			}
			height--;
		}
		return count;
	}
	
	public int getHeight(TreeNode root) {
		if (root == null) {
			return -1;
		}
		return 1 + getHeight(root.left);
	}
}