/**
 *
 * 2.6 Palindrome
 *     Implement a function to check if a linked list is a palindrome.
 *
 *
 */
class Palindrome {
    public static boolean isPalindrome(Node head) {
        Node reverse = reverseCopy(head);
        Node end = reverse;
        
        while (end != null) {
            if (reverse.data != head.data) {
                return false;
            }
            reverse = reverse.next;
            head = head.next;
            if (end.next != null) {
                end = end.next.next;
            } else {
                end = null;
            }
        }
        return true;
    }
    
    public static Node reverseCopy(Node head) {
        if (head == null || head.next == null) { return head; }
        
        Node runner = head.next;
        Node newHead = new Node(head.data);
        while (runner != null) {
            Node temp = new Node(runner.data);
            runner = runner.next;
            newHead = appendTail(temp, newHead);
        }
        return newHead;
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

	public static void main(String[] args) {
		Node head = new Node(1);
        head.appendTail(head, 2);
        head.appendTail(head, 3);
        head.appendTail(head, 4);
        head.appendTail(head, 5);
        head.appendTail(head, 1);
        head.appendTail(head, 5);
        head.appendTail(head, 4);
        head.appendTail(head, 3);
        head.appendTail(head, 2);
        head.appendTail(head, 1);
        head.printList();
        if (isPalindrome(head)) {
            System.out.println("Its a Palindrome");
        } else {
            System.out.println("Its NOT a Palindrome");
        }
	}
}