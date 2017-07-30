import java.util.*;

/**
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
public class Solution {
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		
		ListNode slower = head.next, faster = head.next.next;
		while (slower != faster && faster != null && faster.next != null) {
			slower = slower.next;
			faster = faster.next.next;
		}
		if (slower != faster) {
			return null;
		}
		if (slower == head) {
			return head;
		}
		faster = head;
		while (faster.next != slower.next) {
			faster = faster.next;
			slower = slower.next;
		}
		return faster.next;
	}
}