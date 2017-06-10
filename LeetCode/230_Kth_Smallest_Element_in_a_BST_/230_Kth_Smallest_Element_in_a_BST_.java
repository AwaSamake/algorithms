/**
 *
 *  230. Kth Smallest Element in a BST
 *    Given a binary search tree, write a function kthSmallest to find the kth smallest 
 *    element in it.
 *    
 *    Note: 
 *    You may assume k is always valid, 1 ? k ? BST's total elements.
 *    
 *    Follow up:
 *    What if the BST is modified (insert/delete operations) often and you need to find 
 *    the kth smallest frequently? How would you optimize the kthSmallest routine?
 *    
 *    Credits:
 *    Special thanks to @ts for adding this problem and creating all test cases.
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
	public int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		int index = 0;
		while (!stack.isEmpty() || node != null) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			index++;
			if (index == k) {
				return node.val;
			}
			node = node.right;
		}
		return 0;
	}
}