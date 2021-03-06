/**
 *
 * 110. Balanced Binary Tree
 *     Given a binary tree, determine if it is height-balanced.
 *     For this problem, a height-balanced binary tree is defined as a binary tree in 
 *     which the depth of the two subtrees of every node never differ by more than 1.
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
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (getMaxDepth(root) - getMinDepth(root) > 1) {
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);
	}
	
	public int getMaxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(getMaxDepth(root.left), getMaxDepth(root.right));
	}
	
	public int getMinDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.min(getMaxDepth(root.left), getMaxDepth(root.right));
	}
}