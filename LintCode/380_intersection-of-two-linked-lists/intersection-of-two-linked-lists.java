/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/intersection-of-two-linked-lists
@Language: Java
@Datetime: 17-05-29 21:38
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
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode 
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode runnerA = headA;
        ListNode runnerB = headB;
        int difference = length(headA) - length(headB);
        while (difference > 0) {
            headA = headA.next;
            difference--;
        }
        while (difference < 0) {
            headB = headB.next;
            difference++;
        }
        while (headA != null && headB != null) {
            if (headA != headB) {
                headA = headA.next;
                headB = headB.next;
            } else {
                return headA;
            }
        }
        return null;
    }
    
    public int length(ListNode head) {
        ListNode runner = head;
        int length = 0;
        while (runner != null) {
            length++;
            runner = runner.next;
        }
        return length;
    }
}