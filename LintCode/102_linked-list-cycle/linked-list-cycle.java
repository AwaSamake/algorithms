/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/linked-list-cycle
@Language: Java
@Datetime: 17-06-09 01:20
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
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {  
        if (head == null) {
            return false;
        }
        ListNode slower = head;
        ListNode faster = head.next;
        while (faster != null && faster.next != null) {
            if (faster == slower) {
                return true;
            }
            slower = slower.next;
            faster = faster.next.next;
        }
        return false;
    }
}
