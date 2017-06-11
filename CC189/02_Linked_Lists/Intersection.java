/**
 *
 * 2.7 Intersection
 *     Given two (singly) linked lists, determine if the two lists intersect. Return the
 *     intersecting node of the first linked list is the exact same node (by reference)
 *     as the jth node of the second linked list, then they are intersecting.
 *
 */
class Intersection {
    public static Node findIntersection(Node list1, Node list2) {
        Node longer = null, shorter = null;
        int length1 = getSize(list1), length2 = getSize(list2);
        if (length1 < length2) {
            shorter = list1;
            longer = list2;
        } else {
            shorter = list2;
            longer = list1;
        }
        for (int i = 0; i < Math.abs(length1 - length2); ++i) {
            longer = longer.next;
        }
        
        while (shorter != null && longer != null) {
            if (shorter == longer) {
                return shorter;
            }
            shorter = shorter.next;
            longer = longer.next;
        }
        return null;
    }
    
    public static int getSize(Node head) {
        Node runner = head;
        int size = 0;
        while (runner != null) {
            runner = runner.next;
            ++size;
        }
        return size;
    }
    
	public static void main(String[] args) {
		Node list1 = new Node(1);
        Node.appendTail(list1, 2);
        Node.appendTail(list1, 2);
        Node.appendTail(list1, 3);
        Node.appendTail(list1, 4);

        Node list2 = new Node(1);
        Node.appendTail(list2, 2);
        Node.appendTail(list2, 2);
        
        Node intersection = new Node(100);
        Node.appendTail(list1, intersection);
        Node.appendTail(list2, intersection);
        
        Node.appendTail(list2, 5);
        Node.appendTail(list2, 5);
        Node.appendTail(list2, 1);
        Node.appendTail(list1, 7);
        Node.appendTail(list1, 7);
        
        System.out.println(getSize(list1));
        System.out.println(getSize(list2));
        
        Node found = findIntersection(list1, list2);
        System.out.println(found.data);
	}
}