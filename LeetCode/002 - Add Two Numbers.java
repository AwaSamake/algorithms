/**
 *
 * 002. Add Two Numbers
 *     You are given two non-empty linked lists representing two non-negative integers. 
 *     The digits are stored in reverse order and each of their nodes contain a single 
 *     digit. Add the two numbers and return it as a linked list.
 *     
 *     You may assume the two numbers do not contain any leading zero, except the number 
 *     0 itself.
 *     
 *     Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *     Output: 7 -> 0 -> 8
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
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode head = new ListNode(0);
		ListNode node = head;
		while (l1 != null || l2 != null || carry > 0) {
			int sum = 0;
			if (l1 != null && l2 != null) {
				sum = l1.val + l2.val + carry;
				l1 = l1.next;
				l2 = l2.next;
			} else if (l1 != null) {
				sum = l1.val + carry;
				l1 = l1.next;
			} else if (l2 != null) {
				sum = l2.val + carry;
				l2 = l2.next;
			} else {
				sum = carry;
			}
			node.next = new ListNode(sum % 10);
			node = node.next;
			carry = sum / 10;
		}
		return head.next;
	}
}