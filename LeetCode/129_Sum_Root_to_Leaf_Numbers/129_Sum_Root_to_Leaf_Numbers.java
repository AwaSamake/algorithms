/**
 *
 *  129. Sum Root to Leaf Numbers
 *    Given a binary tree containing digits from 0-9 only, each root-to-leaf path could 
 *    represent a number.
 *    
 *    An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *    
 *    Find the total sum of all root-to-leaf numbers.
 *    
 *    For example,
 *    
 *        1
 *       / \
 *      2   3
 *    The root-to-leaf path 1->2 represents the number 12.
 *    The root-to-leaf path 1->3 represents the number 13.
 *    
 *    Return the sum = 12 + 13 = 25.
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
	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return sumNumbers(root, 0, 0);
		}
	}
	
	public int sumNumbers(TreeNode root, int sum, int val) {
		if (root.left == null && root.right == null) {
			sum += val * 10 + root.val;
			return sum;
		}
		
		int leftSum = 0;
		if (root.left != null) {
			leftSum = sumNumbers(root.left, sum, val * 10 + root.val);
		}
		
		int rightSum = 0;
		if (root.right != null) {
			rightSum = sumNumbers(root.right, sum, val * 10 + root.val);
		}
		return leftSum + rightSum;
	}
}