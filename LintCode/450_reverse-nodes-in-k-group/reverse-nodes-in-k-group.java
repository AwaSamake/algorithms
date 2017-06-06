/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/reverse-nodes-in-k-group
@Language: Java
@Datetime: 17-06-05 23:46
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
	 * @param head a ListNode
	 * @param k an integer
	 * @return a ListNode
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		int length = getLength(head);
		if (length < k || head == null || head.next == null) {
			return head;
		}
		
		ListNode newTail = head;
		ListNode next = head.next, prev = null, node = head;
		for (int i = 0; i < k - 1; ++i) {
			// repoint next to prev
			node.next = prev;
			// reporint prev to current
			prev = node;
			// repoint current to next
			node = next;
			// save next
			next = node.next;
		}
		node.next = prev;
		newTail.next = reverseKGroup(next, k);
		return node;
	}
	
	private int getLength(ListNode head) {
		int counter = 0;
		while (head != null) {
			counter++;
			head = head.next;
		}
		return counter;
	}
}