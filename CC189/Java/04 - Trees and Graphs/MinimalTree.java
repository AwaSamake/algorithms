/**
 *
 * 4.2 Minimal Tree
 *     Given a sorted (increasing order) array with unique integer elements, write an
 *     algorithm to create a binary search tree with minimal height.
 *
 */
import java.util.Random;
import java.util.Arrays;

class MinimalTree {
    
    public static Node makeTree(int[] elements, int lower, int upper) {
        if (lower > upper) {
            return null;
        }
        int mid = (lower + upper) >> 1;
        Node root = new Node(elements[mid]);
        root.children[Node.LEFT] = makeTree(elements, lower, mid - 1);
        root.children[Node.RIGHT] =  makeTree(elements, mid + 1, upper);
        return root;
    }
    
	public static void main(String[] args) {
		Random rand = new Random();
        final int SIZE = 100;
        int[] elements = new int[SIZE];
        
        for (int i = 0; i < SIZE; ++i) {
            elements[i] = Math.abs(rand.nextInt() % 1000);
        }
        Arrays.sort(elements);
        
        Tree tree = new Tree(makeTree(elements, 0, SIZE - 1));
        
        tree.BFS();
        
	}
}