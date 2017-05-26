/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/insertion-sort-list
@Language: Java
@Datetime: 17-05-25 18:43
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
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        ListNode node = head.next;
        head.next = null;
        while(node != null) {
            ListNode next = node.next;
            head = insert(head, node);
            node = next;
        }
        return head;
    }
    
    private ListNode insert(ListNode head, ListNode node) {
        if (node == null) {
            return head;
        }
        node.next = null;
        if (head.val >= node.val) {
            node.next = head;
            return node;
        }
        ListNode walker = head;
        while (walker.next != null) {
            if (walker.next.val > node.val) {
                node.next = walker.next;
                walker.next = node;
                return head;
            }
            walker = walker.next;
        }
        walker.next = node;
        return head;
    }
}