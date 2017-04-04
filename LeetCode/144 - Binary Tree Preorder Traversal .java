/**
 *
 * 144. Binary Tree Preorder Traversal 
 *     Given a binary tree, return the preorder traversal of its nodes' values.
 *     
 *     For example:
 *     Given binary tree {1,#,2,3},
 *        1
 *         \
 *          2
 *         /
 *        3
 *     return [1,2,3].
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
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				list.add(node.val);
				stack.push(node);
				node = node.left;
			}
			node = stack.pop().right;
		}
		return list;
	}
}