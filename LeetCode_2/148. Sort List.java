/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slower = head, faster = head.next;
		while (faster != null && faster.next != null) {
			slower = slower.next;
			faster = faster.next.next;
		}
		faster = slower.next;
		slower.next = null;
		
		head = sortList(head);
		faster = sortList(faster);
		head = merge(head, faster);
		return head;
	}
	
	private ListNode merge(ListNode head1, ListNode head2) {
		ListNode newHead = new ListNode(0);
		ListNode tail = newHead;
		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				tail.next = head1;
				head1 = head1.next;
			} else {
				tail.next = head2;
				head2 = head2.next;
			}
			tail = tail.next;
		}
		if (head1 == null) {
			tail.next = head2;
		} else {
			tail.next = head1;
		}
		return newHead.next;
	}
}