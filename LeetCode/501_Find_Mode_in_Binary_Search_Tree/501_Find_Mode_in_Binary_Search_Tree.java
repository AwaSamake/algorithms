/**
 *
 * 501. Find Mode in Binary Search Tree
 *     Given a binary search tree (BST) with duplicates, find all the mode(s) (the most 
 *     frequently occurred element) in the given BST.
 *     
 *     Assume a BST is defined as follows:
 *     
 *     The left subtree of a node contains only nodes with keys less than or equal to the 
 *     node's key.
 *     The right subtree of a node contains only nodes with keys greater than or equal to 
 *     the node's key.
 *     Both the left and right subtrees must also be binary search trees.
 *     For example:
 *     Given BST [1,null,2,2],
 *        1
 *         \
 *          2
 *         /
 *        2
 *     return [2].
 *     
 *     Note: If a tree has more than one mode, you can return them in any order.
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
	public int[] findMode(TreeNode root) {
		HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
		addToMap(root, freq);
		
		ArrayList<Integer> modes = new ArrayList<Integer>();
		int max = 0;
		
		for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
			if (entry.getValue() > max) {
				max = entry.getValue();
				modes.clear();
			}
			
			if (entry.getValue() == max) {
				modes.add(entry.getKey());
			}
		}
		int[] result = new int[modes.size()];
		int i = 0;
		for (int mode : modes) {
			result[i++] = mode;
		}
		return result;
	}
	
	public void addToMap(TreeNode root, HashMap<Integer, Integer> freq) {
		if (root != null) {
			freq.put(root.val, freq.getOrDefault(root.val, 0) + 1);
			addToMap(root.left, freq);
			addToMap(root.right, freq);
		}
	}
}




// ****************  BUG NEED TO BE FIED   ********************************
public class Solution {
	public int[] findMode(TreeNode root) {
		ArrayList<Integer> modes = new ArrayList<Integer>();
		findMode(root, modes, 0, 1, null);
		
		int[] result = new int[modes.size()];
		int i = 0;
		for (int mode : modes) {
			result[i++] = mode;
		}
		return result;
	}
	
	public void findMode(TreeNode root, ArrayList<Integer> modes, int mode, int count, Integer prev) {
		if (root == null) {
			return;
		}
		findMode(root.left, modes, mode, count, prev);
		if (prev == null) {
			prev = root.val;
		}
		if (root.val == prev) {
			count++;
		} else {
			count = 0;
		}
		if (count > mode) {
			mode = count;
			modes.clear();
		}
		if (count == mode) {
			modes.add(root.val);
		}
		findMode(root.right, modes, mode, count, root.val);
	}
}