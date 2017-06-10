/**
 *
 *  114. Flatten Binary Tree to Linked List
 *     Given a binary tree, flatten it to a linked list in-place.
 *     
 *     For example,
 *     Given
 *     
 *              1
 *             / \
 *            2   5
 *           / \   \
 *          3   4   6
 *     The flattened tree should look like:
 *        1
 *         \
 *          2
 *           \
 *            3
 *             \
 *              4
 *               \
 *                5
 *                 \
 *                  6
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
class Ends {
	TreeNode head, tail;
	
	public Ends(TreeNode head, TreeNode tail) {
		this.head = head;
		this.tail = tail;
	}
}

public class Solution {
	public void flatten(TreeNode root) {
	    if (root == null) {
	        return;
	    }
		flattenTree(root);
	}
	
	public Ends flattenTree(TreeNode root) {
		Ends left = null, right = null;
		if (root.left != null) {
			left = flattenTree(root.left);
		}
		if (root.right != null) {
			right = flattenTree(root.right);
		}
		if (left != null) {
			if (right == null) {
				root.left = null;
				root.right = left.head;
				return new Ends(root, left.tail);
			} else {
				root.left = null;
				left.tail.right = right.head;
				root.right = left.head;
				return new Ends(root, right.tail);
			}
		}
		if (right == null) {
			return new Ends(root, root);
		} else {
			return new Ends(root, right.tail);
		}
	}
}