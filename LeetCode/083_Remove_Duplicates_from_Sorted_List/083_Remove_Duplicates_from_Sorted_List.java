/**
 *
 * 083. Remove Duplicates from Sorted List
 *     Given a sorted linked list, delete all duplicates such that each element appear 
 *     only once.
 *     
 *     For example,
 *     Given 1->1->2, return 1->2.
 *     Given 1->1->2->3->3, return 1->2->3.
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
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slow = head, fast = head.next;
		while (fast != null) {
			if (fast.val > slow.val) {
				slow.next = fast;
				slow = fast;
			}
			fast = fast.next;
		}
		slow.next = null;
		return head;
	}
}