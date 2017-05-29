/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/copy-list-with-random-pointer
@Language: Java
@Datetime: 17-05-29 22:40
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = head;
        RandomListNode dup = new RandomListNode(node.label);
        map.put(node, dup);
        while (node.next != null) {
            dup.next = new RandomListNode(node.next.label);
            dup = dup.next;
            node = node.next;
            map.put(node, dup);
        }
        node = head;
        dup = map.get(node);
        
        while (node != null) {
            dup.random = map.get(node.random);
            node = node.next;
            dup = dup.next;
        }
        return map.get(head);
    }
}