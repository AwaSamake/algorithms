/**
 *
 * 082. Remove Duplicates from Sorted List II
 *    Given a sorted linked list, delete all nodes that have duplicate numbers, leaving 
 *    only distinct numbers from the original list.
 *    
 *    For example,
 *    Given 1->2->3->3->4->4->5, return 1->2->5.
 *    Given 1->1->1->2->3, return 2->3.
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
		if (head == null) {
			return head;
		}
		
		if (head.next != null && head.val == head.next.val) {
			while (head.next != null && head.val == head.next.val) {
				head = head.next;
			}
			return deleteDuplicates(head.next);
		} else {
			head.next = deleteDuplicates(head.next);
			return head;
		}
	}
}

public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode pre = fakeHead;
		ListNode current = head;
		
		while (current != null) {
			while (current.next != null && current.val == current.next.val) {
				current = current.next;
			}
			
			if (pre.next == current) { // without dup
				pre = pre.next;
			} else { // with dup
				pre.next = current.next;
			}
			current = current.next;
		}
		return fakeHead.next;
	}
}