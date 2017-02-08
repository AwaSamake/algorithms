/**
 *
 * 4.6 Successor
 *     Write an algorithm to find the "next" node (i.e., in-order successor) of a given
 *     node in a binary search tree. You may assume that each node has a link to its parent.
 *
 */

class Successor {
    public static Node nextNode(Node node) {
        Node next = null;
        if (node.hasRightChild()) {
            next = node.getRightChild();
            while(next.hasLeftChild()) {
                next = next.getLeftChild();
            }
            return next;
        }
        next = node.getParent();
        while (next != null && next.rightChild() == node) {
            next = next.getParent();
        }
        return next;
    }
    
	public static void main(String[] args) {
		
	}
}