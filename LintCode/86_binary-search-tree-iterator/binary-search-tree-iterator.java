/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/binary-search-tree-iterator
@Language: Java
@Datetime: 17-06-05 05:29
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class BSTIterator {
	Stack<TreeNode> stack;
	
	//@param root: The root of binary tree.
	public BSTIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		addNodes(root);
	}

	//@return: True if there has next node, or false
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	
	//@return: return next node
	public TreeNode next() {
	    if (stack.isEmpty()) {
			return null;
		}
		TreeNode node = stack.pop();
		addNodes(node.right);
		return node;
	}
	
	private void addNodes(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}
}