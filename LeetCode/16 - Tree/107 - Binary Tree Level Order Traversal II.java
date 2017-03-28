/**
 *
 * 107. Binary Tree Level Order Traversal II
 *     Given a binary tree, return the bottom-up level order traversal of its nodes' 
 *     values. (ie, from left to right, level by level from leaf to root).
 *     For example:
 *         Given binary tree [3,9,20,null,null,15,7],
 *             3
 *            / \
 *           9  20
 *             /  \
 *            15   7
 *         return its bottom-up level order traversal as:
 *         [
 *           [15,7],
 *           [9,20],
 *           [3]
 *         ]
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
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> listOfLevel = new ArrayList<List<Integer>>();
		if (root == null) {
			return listOfLevel;
		}
		LinkedList<TreeNode> currentLevel = new LinkedList<TreeNode>();
		currentLevel.add(root);
		while (!currentLevel.isEmpty()) {
			LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();
			ArrayList<Integer> valueOfCurrentLevel = new ArrayList<Integer>();
			while (!currentLevel.isEmpty()) {
				TreeNode node = currentLevel.removeFirst();
				valueOfCurrentLevel.add(node.val);
				if (node.left != null) {
					nextLevel.add(node.left);
				}
				if (node.right != null) {
					nextLevel.add(node.right);
				}
			}
			currentLevel = nextLevel;
			listOfLevel.add(0, valueOfCurrentLevel);
		}
		return listOfLevel;
	}
}