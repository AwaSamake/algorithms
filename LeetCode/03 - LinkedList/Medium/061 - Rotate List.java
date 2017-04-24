/**
 *
 * 061. Rotate List
 *    Given a list, rotate the list to the right by k places, where k is non-negative.
 *    
 *    For example:
 *    Given 1->2->3->4->5->NULL and k = 2,
 *    return 4->5->1->2->3->NULL.
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
	public ListNode rotateRight(ListNode head, int k) {
		if (k < 1 || head == null || head.next == null) {
			return head;
		}
		int length = 0;
		ListNode runner = head;
		while (runner != null) {
			runner = runner.next;
			length++;
		}
		k %= length;
		if (k < 1) {
			return head;
		}

		ListNode slow = head, fast = head;
		int i = 0;
		while (i++ < k && fast != null) {
			fast = fast.next;
		}
		if (fast == null) {
			return head;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		
		ListNode newHead = slow.next;
		slow.next = null;
		fast.next = head;
		return newHead;
	}
}