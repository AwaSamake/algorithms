import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Lihao on 2/2/17.
 * Chapter02 - Linked Lists
 */
class Node {
    Node next = null;
    int data;

    public Node(int d) {
        data = d;
    }

    void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public Node removeNode(Node head, int d) {
        if (head.data == d) {
            return head.next;
        }

        Node n = head;
        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        return head;
    }

}

/**
 *
 * 2.1 Remove Duplicates
 *     Write code to remove duplicates from an unsorted lined list.
 *     FOLLOW UP
 *     How would you solve this problem if a temporary buffer is not allowed?
 *
 */
class RemoveDuplicates {
    public Node removeDup(Node head) {
        Node n = head;
        HashSet<Integer> elements = new HashSet<>();
        elements.add(head.data);
        while (n.next != null) {
            if (elements.contains(n.next.data)) {
                n.next = n.next.next;
            } else {
                elements.add(n.next.data);
            }
            n = n.next;
        }
        return head;
    }

    public Node removeDups(Node head) {
        Node current = head;
        Node runnner = current;
        while (current.next != null) {
            while (runnner.next != null) {
                if (current.data == runnner.next.data) {
                    runnner.next = runnner.next.next;
                } else {
                    runnner = runnner.next;
                }
            }
            current = current.next;
            runnner = current;
        }
        return head;
    }
}


/**
 *
 * 2.2 Return Kth to Last
 *     Implement an algorithm to find the kth to last element of a singly lined list.
 *
 */

class KToLast {
    // Solution #1
    public Node KthToLast(Node head, int k) {
        int count = 0;
        Node n = head;
        while (n.next != null) {
            n = n.next;
            ++count;
        }
        int steps = count - k;
        n = head;
        while (steps > 0) {
            n = n.next;
        }
        return n;
    }

    // Solution #2
    public int printKthToLast(Node head, int k) {
        if (head == null) {
            return 1;
        }
        int index = printKthToLast(head.next, k);
        if (index == k) {
            System.out.println(head.data);
        }
        return index + 1;
    }

    // Solution #3
    public Node KthToLast3(Node head, int k) {
        Node p1 = head;
        Node p2 = head;
        for (int i = 0; i < k; ++i) {
            if (p2 == null) {
                return null;
            }
            p2 = p2.next;
        }
        while (p2 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;
    }

}


/**
 *
 * 2.3 Delete Middle Node
 *     Implement an algorithm to delete a node in the middle (i.e., any node but the
 *     first and last node, not necessarily the exact middle) of a singly linked list,
 *     given only access to that node.
 *     EXAMPLE
 *     Input: that node c from the linked list a->b->c->d->e->f
 *     Result: nothing is returned, but the new linked list looks like a->b->d->e->f
 *
 */

class  DeleteMiddleNode {
    public boolean deleteMiddle(Node n) {
        if (n == null || n.next == null) {
            return false;
        }
        n.data = n.next.data;
        n.next = n.next.next;
        return true;
    }

}



/**
 *
 * 2.4 Partition
 *     Write code to partition a linked list around a value x, such that all nodes less
 *     than x come before all nodes greater than or equal to x, if x is contained within
 *     the list, the values of x only need to be after the elements less that x(see below).
 *     The partition element x can appear anywhere in the "right partition"; It does not
 *     need to appear between the left and right partitions.
 *
 */


/**
 *
 * 2.5 Sum Lists
 *     You have two numbers represented by a linked list, where each node contains a
 *     single digit. The digits are stored in reverse order, such that the 1's digit is
 *     at the head of the list. Weite a function that adds the two numbers and returns
 *     the sum as a linked list.
 *     EXAMPLE
 *     Input: (7-> 1-> 6) + (5-> 9-> 2). That is, 617 + 295
 *     Output: 2-> 1-> 9. That is, 912
 *     FOLLOW UP
 *     Suppose the digits are stored in forward order. Repeat the above problem.
 *     Input: (6-> 1-> 7) + (2-> 9-> 5). That is, 617 + 295
 *     Output: 9-> 1-> 2. That is, 912
 *
 */


/**
 *
 * 2.6 Palindrome
 *     Implement a function to check if a linked list is a palindrome.
 *
 *
 */


/**
 *
 * 2.7 Intersection
 *     Given two (singly) linked lists, determine if the two lists intersect. Return the
 *      intersecting node of the first linked list is the exact same node (by reference)
 *      as the jth node of the second linked list, then they are intersecting.
 *
 */


/**
 *
 * 2.8 Loop Detection
 *     Given a circular linked list, implement an algorithm that returns the code at the
 *     beginning of the loop.
 *     DEFINITION
 *     Circular linked list: A (corrupt) linked list in which a node's next pointer points
 *     to an earlier node, so as to make a loop in the linked list.
 *     EXAMPLE
 *     Input: A -> B -> C -> D -> E -> C[the same C as earlier]
 *     Output: C
 *
 */
