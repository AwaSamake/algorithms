/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/reverse-linked-list-ii
@Language: Java
@Datetime: 17-05-26 20:26
*/

/**
 * Definition for ListNode
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
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
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