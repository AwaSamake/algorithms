/**
 *
 * 021. Merge Two Sorted Lists
 *     Merge two sorted linked lists and return it as a new list. The new list should be 
 *     made by splicing together the nodes of the first two lists.
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
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}
		
		
		ListNode head;
		if (l1.val > l2.val) {
			head = l2;
			l2 = l2.next;
		} else {
			head = l1;
			l1 = l1.next;
		}
		ListNode walker = head;
		
		while (l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				walker.next = l2;
				l2 = l2.next;
			} else {
				walker.next = l1;
				l1 = l1.next;
			}
			walker = walker.next;
		}
		walker.next = l1 == null ? l2 : l1;
		return head;
	}
}