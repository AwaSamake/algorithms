/**
 *
 * 2.4 Partition
 *     Write code to partition a linked list around a value x, such that all nodes less
 *     than x come before all nodes greater than or equal to x, if x is contained within
 *     the list, the values of x only need to be after the elements less that x(see below).
 *     The partition element x can appear anywhere in the "right partition"; It does not
 *     need to appear between the left and right partitions.
 *     EXAMPLE
 *     Input:   3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1[partition = 5]
 *     Output:  3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 *
 */
class linkedList {
    public Node head;
    private Node tail;
    
    public linkedList() {
        head = null;
        tail = null;
    }
    
    public void appendTail(Node node) {
        if (head == null) {
            head = node;
            tail = node;
            return;
        } else {
            tail.next = node;
            tail = tail.next;
        }
    }
}

class Partition {
    public static Node partition(Node head, int x) {
        linkedList smaller = new linkedList();
        linkedList bigger = new linkedList();
        
        while (head != null) {
            Node temp = head;
            head = head.next;
            temp.next = null;
            if (temp.data < x) {
                smaller.appendTail(temp);
            } else {
                bigger.appendTail(temp);
            }
        }
        smaller.appendTail(bigger.head);
        return smaller.head;
    }
    
	public static void main(String[] args) {
		Node head = new Node(3);
        head.appendTail(head, 5);
        head.appendTail(head, 8);
        head.appendTail(head, 5);
        head.appendTail(head, 10);
        head.appendTail(head, 2);
        head.appendTail(head, 1);
        
        head.printList(head);
        head = partition(head, 5);
        head.printList(head);
	}
}