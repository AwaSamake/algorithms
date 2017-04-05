/**
 *
 * 236. Lowest Common Ancestor of a Binary Tree
 *     Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in 
 *     the tree.
 *     
 *     According to the definition of LCA on Wikipedia: “The lowest common ancestor is 
 *     defined between two nodes v and w as the lowest node in T that has both v and w as 
 *     descendants (where we allow a node to be a descendant of itself).”
 *     
 *             _______3______
 *            /              \
 *         ___5__          ___1__
 *        /      \        /      \
 *        6      _2       0       8
 *              /  \
 *              7   4
 *     For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another 
 *     example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself 
 *     according to the LCA definition.
 *     
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
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (!cover(root, p) || !cover(root, q)) {
			return null;
		}
		return commonAncestorHelper(root, p, q);
	}
	
	public TreeNode commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null) {
			return root;
		}
		boolean pIsOnLeft = cover(root.left, p);
		boolean qIsOnLeft = cover(root.left, p);
		// if pIsOnLeft and qIsOnLeft are not equal means only one of them not on left
		if (pIsOnLeft != qIsOnLeft) {
			// root will be the common ancestor
			return root;
		}
		// if pIsOnLeft and qIsOnLeft are not equal means both of them on same side
		TreeNode whichChild = pIsOnLeft ? root.left : root.right;
		return commonAncestorHelper(whichChild, p, q);
	}
	
	public boolean cover(TreeNode root, TreeNode node) {
		if (root == null) {
			return false;
		}
		if (root == node) {
			return true;
		}
		return cover(root.left, node) || cover(root.right, node);
	}
}