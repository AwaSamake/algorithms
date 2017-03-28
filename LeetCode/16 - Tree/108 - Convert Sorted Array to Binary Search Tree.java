/**
 *
 * 108. Convert Sorted Array to Binary Search Tree
 *     Given an array where elements are sorted in ascending order, convert it to a 
 *     height balanced BST.
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
	public TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBST(nums, 0, nums.length - 1);
	}
	
	public TreeNode sortedArrayToBST(int[] nums, int low, int high) {
		if (low > high) {
			return null;
		}
		int mid = (low + high) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = sortedArrayToBST(nums, low, mid - 1);
		node.right = sortedArrayToBST(nums, mid + 1, high);
		return node;
	}
}