/**
 *
 * 102. Binary Tree Level Order Traversal
 *     Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *     
 *     For example:
 *     Given binary tree [3,9,20,null,null,15,7],
 *         3
 *        / \
 *       9  20
 *         /  \
 *        15   7
 *     return its level order traversal as:
 *     [
 *       [3],
 *       [9,20],
 *       [15,7]
 *     ]
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
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> listOfLevels = new ArrayList<List<Integer>>();
		if (root == null) {
			return listOfLevels;
		}
		LinkedList<TreeNode> currentLevel, nextLevel = new LinkedList<TreeNode>();
		nextLevel.add(root);
		while (!nextLevel.isEmpty()) {
			currentLevel = nextLevel;
			nextLevel = new LinkedList<TreeNode>();
			List<Integer> level = new ArrayList<Integer>();
			while (!currentLevel.isEmpty()) {
				TreeNode node = currentLevel.removeFirst();
				level.add(node.val);
				if (node.left != null) {
					nextLevel.add(node.left);
				}
				if (node.right != null) {
					nextLevel.add(node.right);
				}
			}
			listOfLevels.add(level);
		}
		return listOfLevels;
	}
}