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
class LoopDetection {
    public static boolean findBeginning(Node head) {
        Node fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) { return null; }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
    
	public static void main(String[] args) {
		
	}
}