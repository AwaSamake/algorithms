/**
 *
 * 2.1 Remove Duplicates
 *     Write code to remove duplicates from an unsorted lined list.
 *     FOLLOW UP
 *     How would you solve this problem if a temporary buffer is not allowed?
 *
 */
class RemoveDuplicates {
/**
     * Method #1:
     */
    public static Node removeDuplicate1(Node head) {
        Node n = head;
        HashSet<Integer> elements = new HashSet<>();
        elements.add(head.data);
        while (n != null && n.next != null) {
            if (elements.contains(n.next.data)) {
                n.next = n.next.next;
            } else {
                elements.add(n.next.data);
                n = n.next;
            }
        }
        return head;
    }

    /**
     * Method #2:
     */
    public static Node removeDuplicate2(Node head) {
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
    
    /**
     * Testing remove duplicate methods
     */
    public static void main(String[] args) {
        Node head = new Node(1);
        head.appendTail(head, 2);
        head.appendTail(head, 2);
        head.appendTail(head, 3);
        head.appendTail(head, 4);
        head.appendTail(head, 5);
        head.appendTail(head, 5);
        head.appendTail(head, 1);
        head.appendTail(head, 7);
        head.appendTail(head, 7);
                
        head.printList(head);
        head = removeDuplicate1(head);
        head.printList(head);
        head = removeDuplicate2(head);
        head.printList(head);
    }
}