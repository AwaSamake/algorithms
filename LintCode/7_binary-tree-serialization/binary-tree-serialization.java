/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/binary-tree-serialization
@Language: Java
@Datetime: 17-05-27 03:49
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
class Solution {
private int index = 0;
	/**
	 * This method will be invoked first, you should design your own algorithm 
	 * to serialize a binary tree which denote by a root node to a string which
	 * can be easily deserialized by your own "deserialize" method later.
	 */
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		return sb.substring(0, sb.length() - 1);
	}
	
	public void serialize(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("#,");
			return;
		}
		sb.append(root.val);
		sb.append(",");
		serialize(root.left, sb);
		serialize(root.right, sb);
	}
	
	/**
	 * This method will be invoked second, the argument data is what exactly
	 * you serialized at method "serialize", that means the data is not given by
	 * system, it's given by your own serialize method. So the format of data is
	 * designed by yourself, and deserialize it here as you serialize it in 
	 * "serialize" method.
	 */
	public TreeNode deserialize(String data) {
		String[] nodes = data.split(",");
		return deserialize(nodes);
	}

	public TreeNode deserialize(String[] nodes) {
		if (index >= nodes.length || "#".equals(nodes[index])) {
			index++;
			return null;
		}
		int value = Integer.valueOf(nodes[index]);
		index++;
		TreeNode node = new TreeNode(value);
		node.left = deserialize(nodes);
		node.right = deserialize(nodes);
		return node;
	}
}
