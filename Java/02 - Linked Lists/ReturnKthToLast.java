/**
 *
 * 2.2 Return Kth to Last
 *     Implement an algorithm to find the kth to last element of a singly lined list.
 *
 */
class ReturnKthToLast {
    // Solution #1
    public Node KthToLast1(Node head, int k) {
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
    public int KthToLast2(Node head, int k) {
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
    
	public static void main(String[] args) {
		
	}
}