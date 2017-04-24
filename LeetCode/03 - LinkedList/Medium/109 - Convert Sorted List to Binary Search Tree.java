/**
 *
 * 109. Convert Sorted List to Binary Search Tree
 *    Given a singly linked list where elements are sorted in ascending order, convert it 
 *    to a height balanced BST.
 *
 */
import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
		    return new TreeNode(head.val);
		}
		ListNode slow = head, fast = head.next;
		
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode next = slow.next;
		slow.next = null;
		TreeNode root = new TreeNode(next.val);

		root.left = sortedListToBST(head);
		root.right = sortedListToBST(next.next);
		
		return root;
	}
}