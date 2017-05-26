/**
 *
 * 092. Reverse Linked List II
 *    Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 *    For example:
 *    Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 *
 *    return 1->4->3->2->5->NULL.
 *
 *    Note:
 *    Given m, n satisfy the following condition:
 *    1 ≤ m ≤ n ≤ length of list.
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
    public ListNode reverseBetween(ListNode head, int m , int n) {
        if (m >= n || head == null) {
            return head;
        }
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode slower = temp, faster = head;
        for (int i = 0; i < m - 1; ++i) {
            slower = slower.next;
        }
        for (int i = 0; i < n; ++i) {
            faster = faster.next;
        }

        slower.next = reverseUntil(slower.next, faster);
        return temp.next;
    }

    private ListNode reverseUntil(ListNode head, ListNode end) {
        ListNode next = head.next;
        head.next = end;

        while (next.next != end) {
            ListNode temp = next;
            next = next.next;
            temp.next = head;
            head = temp;
        }
        next.next = head;
        return next;
    }
}
