/**
 *
 * 203. Remove Linked List Elements
 *     Remove all elements from a linked list of integers that have value val.
 *     
 *     Example
 *     Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 *     Return: 1 --> 2 --> 3 --> 4 --> 5
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
public class Solution {
	public ListNode removeElements(ListNode head, int val) {
		while (head != null && head.val == val) {
			head = head.next;
		}
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slow = head, fast = head.next;
		while (fast != null) {
			if (fast.val != val) {
				slow.next = fast;
				slow = slow.next;
			}
			fast = fast.next;
		}
		slow.next = null;
		return head;
	}
}