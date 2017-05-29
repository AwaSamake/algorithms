/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/swap-two-nodes-in-linked-list
@Language: Java
@Datetime: 17-05-28 22:17
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        ListNode node = new ListNode(0);
        node.next = head;
        head = node;
        ListNode n1 = null, n2 = null;
        
        while (node.next != null && (n1 == null || n2 == null)) {
            if (node.next.val == v1) {
                n1 = node;
            }
            if (node.next.val == v2) {
                n2 = node;
            }
            node = node.next;
        }
        if (n1 == null || n2 == null) {
            return head.next;
        }
        ListNode temp = n1.next;
        n1.next = n2.next;
        n2.next = temp;
        ListNode temp2 = n1.next.next;
        n1.next.next = temp.next;
        n2.next = temp;
        temp.next = temp2;
        return head.next;
    }
}