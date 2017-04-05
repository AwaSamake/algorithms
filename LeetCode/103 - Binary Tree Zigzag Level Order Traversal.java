/**
 *
 * 103. Binary Tree Zigzag Level Order Traversal
 *     Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 *     (ie, from left to right, then right to left for the next level and alternate 
 *     between).
 *     
 *     For example:
 *     Given binary tree [3,9,20,null,null,15,7],
 *         3
 *        / \
 *       9  20
 *         /  \
 *        15   7
 *     return its zigzag level order traversal as:
 *     [
 *       [3],
 *       [20,9],
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
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> listOfLevels = new LinkedList<List<Integer>>();
		if (root == null) {
			return listOfLevels;
		}
		LinkedList<TreeNode> currentLevel, nextLevel = new LinkedList<TreeNode>();
		nextLevel.add(root);
		boolean leftToRight = true;
		while (!nextLevel.isEmpty()) {
			currentLevel = nextLevel;
			nextLevel = new LinkedList<TreeNode>();
			LinkedList<Integer> level = new LinkedList<Integer>();
			while (!currentLevel.isEmpty()) {
				TreeNode node = currentLevel.removeFirst();
				if (leftToRight) {
					level.add(node.val);
				} else {
					level.addFirst(node.val);
				}
				if (node.left != null) {
					nextLevel.add(node.left);
				}
				if (node.right != null) {
					nextLevel.add(node.right);
				}
			}
			listOfLevels.add(level);
			leftToRight = !leftToRight;
		}
		return listOfLevels;
	}
}