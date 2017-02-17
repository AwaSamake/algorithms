/**
 *
 * 4.11 Random Node
 *     You are implementing a binary search tree class form scratch, which, in addition
 *     to insert, find, and delete, has a method getRandomNode() which returns a random
 *     node from the tree. All nodes should be equally likely to be chosen. Design and
 *     implement an algorithm for getRandomNode, and explain how you would implement the
 *     rest of the methods.
 *
 */

import java.util.*;

/**
 *
 * Solution #1
 *     Keeping a counter of Node in Subtree 
 *
 */
class Node {
    private int data;
    public Node left;
    public Node right;
    private int size = 0;
    
    public Node(int d) {
        data = d;
        size = 1;
    }
    
    public Node getRandomNode() {
        int leftSize = left == null ? 0 left.size();
        Random random = new Random();
        int index = random.nextInt(size);
        if (index < leftSize) {
            return left.getRandomNode();
        } else if (index == leftSize) {
            return this;
        } else {
            return right.getRandomNode();
        }
    }
    
    public void insertInOrder(int d) {
        if (d <= data) {
            if (left == null) {
                left = new Node(d);
            } else {
                left.insertInOrder(d);
            }
        } else {
            if (right == null) {
                right = new Node(d);
            } else {
                right.insertInOrder(d);
            }
        }
        size++;
    }
    
    public int size() {
        return size;
    }
    
    public int data() {
        return data;
    }
    
    public Node find(int d) {
        if (d == data) {
            return this;
        } else if (d < data) {
            return left != null ? left.find(d) : null;
        } else {
            return right != null ? right.find(d) : null;
        }
    }
}


class RandomNode {
	public static void main(String[] args) {
		
	}
}
































