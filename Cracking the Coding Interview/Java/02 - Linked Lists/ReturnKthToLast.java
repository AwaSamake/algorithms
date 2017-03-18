/**
 *
 * 2.2 Return Kth to Last
 *     Implement an algorithm to find the kth to last element of a singly lined list.
 *
 */
class ReturnKthToLast {
    // Solution #1
    public static Node KthToLast1(Node head, int k) {
        int count = 0;
        Node n = head;
        while (n.next != null) {
            n = n.next;
            ++count;
        }
        int steps = count - k;
        n = head;
        while (steps >= 0) {
            n = n.next;
            --steps;
        }
        return n;
    }

    // Solution #2
    public static int KthToLast2(Node head, int k) {
        if (head == null) {
            return 1;
        }
        int index = KthToLast2(head.next, k);
        if (index == k) {
            System.out.println(head.data);
        }
        return index + 1;
    }

    // Solution #3
    public static Node KthToLast3(Node head, int k) {
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
        head.printList();
        
        int k = 1;
        System.out.println("Method #1:" + KthToLast1(head, k).data);
        
        System.out.print("Method #2:");
        KthToLast2(head, k);
        
        System.out.println("Method #3:" + KthToLast3(head, k).data);
	}
}