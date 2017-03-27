/**
 *
 * 234. Palindrome Linked List
 *     Given a singly linked list, determine if it is a palindrome.
 * Follow up:
 *     Could you do it in O(n) time and O(1) space?
 * 
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.*;

public class Solution {
	public boolean isPalindrome(ListNode head) {
		if (head == null) {
			return true;
		}
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode head2 = reverse(slow);
		
		while (head != null && head2 != null && head != head2) {
			if (head.val != head2.val) {
				return false;
			}
			head = head.next;
			head2 = head2.next;
		}
		return true;
	}
	
	public static ListNode reverse(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode pre = null;
		ListNode next = head.next;
		head.next = pre;
		while (next != null) {
			pre = head;
			head = next;
			next = next.next;
			head.next = pre;
		}
		return head;
	}
}