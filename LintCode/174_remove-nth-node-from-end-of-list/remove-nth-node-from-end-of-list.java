/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/remove-nth-node-from-end-of-list
@Language: Java
@Datetime: 17-06-09 21:41
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
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode faster = fakeHead;
        ListNode slower = fakeHead;
        for (int i = 0; i < n; ++i) {
            if (faster.next == null) {
                return fakeHead.next;
            }
            faster = faster.next;
        }
        while (faster.next != null) {
            slower = slower.next;
            faster = faster.next;
        }
        slower.next = slower.next.next;
        return fakeHead.next;
    }
}
