/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/partition-list
@Language: Java
@Datetime: 17-06-02 04:55
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
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode runner = head;
        ListNode smallerHead = new ListNode(0);
        ListNode biggerHead = new ListNode(0);
        ListNode smaller = smallerHead;
        ListNode bigger = biggerHead;
        
        while (runner != null) {
            if (runner.val < x) {
                smaller.next = runner;
                runner = runner.next;
                smaller = smaller.next;
                smaller.next = null;
            } else {
                bigger.next = runner;
                runner = runner.next;
                bigger = bigger.next;
                bigger.next = null;
            }
        }
        smaller.next = biggerHead.next;
        return smallerHead.next;
    }
}
