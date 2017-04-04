/**
 *
 * 094. Binary Tree Inorder Traversal
 *     Given a binary tree, return the inorder traversal of its nodes' values.
 *     
 *     For example:
 *     Given binary tree [1,null,2,3],
 *        1
 *         \
 *          2
 *         /
 *        3
 *     return [1,3,2].
 *     
 *     Note: Recursive solution is trivial, could you do it iteratively?
 *     
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
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			list.add(node.val);
			node = node.right;
		}
		return list;
	}
}