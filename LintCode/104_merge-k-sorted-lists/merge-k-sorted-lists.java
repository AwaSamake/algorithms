/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/merge-k-sorted-lists
@Language: Java
@Datetime: 17-06-09 01:40
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
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        ListNode head = null;
        for (ListNode list : lists) {
            head = mergeTwoLists(head, list);
        }
        return head;
    }
    
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode newHead = new ListNode(0);
        ListNode runner = newHead;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                runner.next = head1;
                head1 = head1.next;
            } else {
                runner.next = head2;
                head2 = head2.next;
            }
            runner = runner.next;
            runner.next = null;
        }
        if (head1 == null) {
            runner.next = head2;
        } else {
            runner.next = head1;
        }
        return newHead.next;
    }
}
