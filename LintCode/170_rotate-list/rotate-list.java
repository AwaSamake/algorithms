/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/rotate-list
@Language: Java
@Datetime: 17-06-05 05:45
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        int length = 0;
        ListNode runner = head;
        while (runner != null) {
            runner = runner.next;
            length ++;
        }
        if (head == null || head.next == null || k % length == 0) {
            return head;
        }
        ListNode faster = head;
        ListNode slower = head;
        k %= length;
        for (int i = 0; i < k && faster != null; ++i) {
            // System.out.println(faster.val);
            faster = faster.next;
        }
        if (faster == null) {
            return head;
        }
        // System.out.println(faster.val);
        while (faster.next != null) {
            faster = faster.next;
            slower = slower.next;
        }
        faster.next = head;
        head = slower.next;
        slower.next = null;
        return head;
    }
}