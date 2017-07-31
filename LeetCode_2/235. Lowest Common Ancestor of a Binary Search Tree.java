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
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null) {
			return null;
		}
		if (root.val < p.val && root.val < q.val) {
			return lowestCommonAncestor(root.right, p, q);
		}
		if (root.val > p.val && root.val > q.val) {
			return lowestCommonAncestor(root.left, p, q);
		}
		int min = Math.min(p.val, q.val);
		int max = Math.max(p.val, q.val);
		if (root.val == min && root.val <= max) {
			return root;
		}
		if (root.val == max && root.val > min) {
			return root;
		}
		if (root.val <= max && root.val > min) {
			return root;
		}
		return null;
	}
}