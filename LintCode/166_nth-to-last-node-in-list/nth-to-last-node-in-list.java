/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/nth-to-last-node-in-list
@Language: Java
@Datetime: 17-06-09 21:57
*/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list. 
     */
    ListNode nthToLast(ListNode head, int n) {
        ListNode runner = head;
        for (int i = 0; i < n; ++i) {
            if (runner == null) {
                return null;
            }
            runner = runner.next;
        }
        while (runner != null) {
            runner = runner.next;
            head = head.next;
        }
        return head;
    }
}
