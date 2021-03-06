/**
 *
 * 543. Diameter of Binary Tree
 *     Given a binary tree, you need to compute the length of the diameter of the tree. 
 *     The diameter of a binary tree is the length of the longest path between any two 
 *     nodes in a tree. This path may or may not pass through the root.
 *     
 *     Example:
 *     Given a binary tree 
 *               1
 *              / \
 *             2   3
 *            / \     
 *           4   5    
 *     Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *     
 *     Note: The length of path between two nodes is represented by the number of edges 
 *     between them.
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
	public int diameterOfBinaryTree(TreeNode root) {
		return diameterOfBinaryTree(root, 0);
	}
	
	public int diameterOfBinaryTree(TreeNode root, int max) {
		if (root == null) {
			return max;
		}
		int maxLeft = getMaxDepth(root.left);
		int maxRight = getMaxDepth(root.right);
		max = Math.max(max, maxLeft + maxRight);
		if (maxLeft == maxRight) {
			return Math.max(diameterOfBinaryTree(root.left, max), diameterOfBinaryTree(root.right, max));
		}
		return (maxLeft > maxRight) ? diameterOfBinaryTree(root.left, max) : diameterOfBinaryTree(root.right, max);
	}
		
	
	public int getMaxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(getMaxDepth(root.left), getMaxDepth(root.right));
	}
}