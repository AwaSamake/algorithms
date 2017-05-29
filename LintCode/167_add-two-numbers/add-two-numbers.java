/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/add-two-numbers
@Language: Java
@Datetime: 17-05-29 03:56
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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode current = result;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            current.next = new ListNode(carry % 10);
            current = current.next;
            carry /= 10;
        }
        if (result.next != null) {
            return result.next;
        }
        return result;
    }
}