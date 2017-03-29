/**
 *
 * 257. Binary Tree Paths
 *     Given a binary tree, return all root-to-leaf paths.
 *     
 *     For example, given the following binary tree:
 *     
 *        1
 *      /   \
 *     2     3
 *      \
 *       5
 *     All root-to-leaf paths are:
 *     
 *     ["1->2->5", "1->3"]
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
	public List<String> binaryTreePaths(TreeNode root) {
		ArrayList<String> paths = new ArrayList<String>();
		if (root == null) {
			return paths;
		}
		binaryTreePaths(root, paths, "");
		return paths;
	}
	
	public void binaryTreePaths(TreeNode root, List<String> paths, String path) {
		path = path + "->" + root.val;
		if (root.left == null && root.right == null) {
			paths.add(path.substring(2));
			return;
		}
		if (root.left != null) {
			binaryTreePaths(root.left, paths, path);
		}
		if (root.right != null) {
			binaryTreePaths(root.right, paths, path);
		}
	}
}