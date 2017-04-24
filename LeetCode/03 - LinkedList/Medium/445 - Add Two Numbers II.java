/**
 *
 * 445. Add Two Numbers II
 *     You are given two non-empty linked lists representing two non-negative integers. 
 *     The most significant digit comes first and each of their nodes contain a single 
 *     digit. Add the two numbers and return it as a linked list.
 *     
 *     You may assume the two numbers do not contain any leading zero, except the number 
 *     0 itself.
 *     
 *     Follow up:
 *     What if you cannot modify the input lists? In other words, reversing the lists is 
 *     not allowed.
 *     
 *     Example:
 *     
 *     Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 *     Output: 7 -> 8 -> 0 -> 7
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
		ListNode l1r = reverse(l1);
		ListNode l2r = reverse(l2);
		
		int sum = l1r.val + l2r.val;
		int carry = sum / 10;
		sum %= 10;
		ListNode l3r = new ListNode(sum);
		ListNode runner = l3r;
		l1r = l1r.next;
		l2r = l2r.next;
		while (l1r != null || l2r != null) {
			sum = carry;
			carry = 0;
			
			if (l1r != null) {
				sum += l1r.val;
				l1r = l1r.next;
			}
			if (l2r != null) {
				sum += l2r.val;
				l2r = l2r.next;
			}
			
			carry = sum / 10;
			sum %= 10;
			runner.next = new ListNode(sum);
			runner = runner.next;
		}
		if (carry > 0) {
			runner.next = new ListNode(carry);
		}
		return reverse(l3r);
	}
	
	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = null;
		ListNode next = null;
		
		while (head.next != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		head.next = pre;
		return head;
	}
}