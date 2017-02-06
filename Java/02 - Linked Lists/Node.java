/**
 *
 * 2.0 Node
 *
 */

public class Node {
    public Node next = null;
    public int data;

    public Node(int d) {
        data = d;
    }

    public static Node appendTail(Node head, int d) {
        Node newNode = new Node(d);
        return appendTail(head, newNode);
    }
    
    public static Node appendTail(Node head, Node node) {
        if (head == null) {
            return node;
        }
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = node;
        return head;
    }

    public void printList() {
        System.out.print(data + " ");
        Node node = next;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}