/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/binary-tree-zigzag-level-order-traversal
@Language: Java
@Datetime: 17-06-06 00:32
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
 */
 
 
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return results;
		}
		Stack<TreeNode> currentStack = new Stack<>();
		Stack<TreeNode> nextStack = new Stack<>();
		currentStack.push(root);
		boolean oddLevel = true;
		
		while (!currentStack.isEmpty()) {
			ArrayList<Integer> nums = new ArrayList<Integer>();
			while (!currentStack.isEmpty()) {
				TreeNode node = currentStack.pop();
				nums.add(node.val);
				if (oddLevel) {
    				if (node.left != null) {
    					nextStack.push(node.left);
    				}
    				if (node.right != null) {
    					nextStack.push(node.right);
    				}
				} else {
    				if (node.right != null) {
    					nextStack.push(node.right);
    				}
    				if (node.left != null) {
    					nextStack.push(node.left);
    				}
				}
			}
			Stack<TreeNode> temp = currentStack;
			currentStack = nextStack;
			nextStack = temp;
			oddLevel = !oddLevel;
			results.add(nums);
		}
		return results;
	}
}