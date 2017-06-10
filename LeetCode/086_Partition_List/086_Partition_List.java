/**
 *
 * 086. Partition List
 *     Given a linked list and a value x, partition it such that all nodes less than x 
 *     come before nodes greater than or equal to x.
 *     
 *     You should preserve the original relative order of the nodes in each of the two 
 *     partitions.
 *     
 *     For example,
 *     Given 1->4->3->2->5->2 and x = 3,
 *     return 1->2->2->4->3->5.
 *     
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
	public ListNode partition(ListNode head, int x) {
		ListNode smallHead = new ListNode(0);
		ListNode largeHead = new ListNode(0);
		ListNode headRunner = head;
		ListNode smallRunner = smallHead;
		ListNode largeRunner = largeHead;
		while (headRunner != null) {
			if (headRunner.val < x) {
				smallRunner.next = headRunner;
				smallRunner = smallRunner.next;
			} else {
				largeRunner.next = headRunner;
				largeRunner = largeRunner.next;
			}
			headRunner = headRunner.next;
		}
		largeRunner.next = null;
		smallRunner.next = largeHead.next;
		return smallHead.next;
	}
}