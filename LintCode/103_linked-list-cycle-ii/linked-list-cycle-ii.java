/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/linked-list-cycle-ii
@Language: Java
@Datetime: 17-06-09 01:26
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
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {  
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slower = head;
        ListNode faster = head.next;
        
        while (faster != null && faster.next != null) {
            if (faster == slower) {
                break;
            }
            slower = slower.next;
            faster = faster.next.next;
        }
        if (faster == null || faster.next== null) {
            return null;
        }
        faster = head;
        while (faster != slower.next) {
            faster = faster.next;
            slower = slower.next;
        }
        return slower.next;
    }
}
