/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/binary-tree-paths
@Language: Java
@Datetime: 17-05-29 03:21
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
	 * @param root the root of the binary tree
	 * @return all root-to-leaf paths
	 */
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new ArrayList<>();
		binaryTreePaths(root, list, new ArrayList<String>());
		return list;
	}
	
	private void binaryTreePaths(TreeNode root, List<String> list, List<String> path) {
		if (root == null) {
			return;
		}
		path.add(Integer.toString(root.val));
		if (root.left == null && root.right == null) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < path.size() - 1; ++i) {
				sb.append(path.get(i));
				sb.append("->");
			}
			sb.append(path.get(path.size() - 1));
			list.add(sb.toString());
		} else {
			if (root.left != null) {
				binaryTreePaths(root.left, list, path);
			}
			if (root.right != null) {
				binaryTreePaths(root.right, list, path);
			}
		}
		path.remove(path.size() - 1);
	}
}