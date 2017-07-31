/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Result {
	public int include;
	public int exclude;
	
	public Result(int include, int exclude) {
		this.include = include;
		this.exclude = exclude;
	}
}

public class Solution {
	public int rob(TreeNode root) {
		Result result = robHelper(root);
		return Math.max(result.include, result.exclude);
	}
	
	private Result robHelper(TreeNode root) {
		if (root == null) {
			return new Result(0, 0);
		}

		Result left = robHelper(root.left);
		Result right = robHelper(root.right);
		return new Result(root.val + left.exclude + right.exclude, 
						  Math.max(left.include, left.exclude) + Math.max(right.include, right.exclude));
	}
}