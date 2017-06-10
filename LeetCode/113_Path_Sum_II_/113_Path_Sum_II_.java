/**
 *
 *  113. Path Sum II 
 *    Given a binary tree and a sum, find all root-to-leaf paths where each path's sum 
 *    equals the given sum.
 *    
 *    For example:
 *    Given the below binary tree and sum = 22,
 *                  5
 *                 / \
 *                4   8
 *               /   / \
 *              11  13  4
 *             /  \    / \
 *            7    2  5   1
 *    return
 *    [
 *       [5,4,11,2],
 *       [5,8,4,5]
 *    ]
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
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> paths = new ArrayList<List<Integer>>();
		if (root == null) {
			return paths;
		}
		pathSum(root, sum, paths, new ArrayList<Integer>());
		return paths;
	}
	
	private void pathSum(TreeNode root, int sum, List<List<Integer>> paths, List<Integer> path) {
		if (root.left == null && root.right == null && sum == root.val) {
			path.add(root.val);
			paths.add(path);
			return;
		}
		if (root.left != null) {
			List<Integer> pathDup1 = new ArrayList<Integer>(path);
			pathDup1.add(root.val);
			pathSum(root.left, sum - root.val, paths, pathDup1);
			
		} 
		if (root.right != null) {
			List<Integer> pathDup2 = new ArrayList<Integer>(path);
			pathDup2.add(root.val);
			pathSum(root.right, sum - root.val, paths, pathDup2);
		}
	}
}