/**
 *
 * 4.4 Check Balanced
 *     Implement a function to check if a binary tree is balanced. For the purposes of
 *     this question, a balanced tree is defined to be a tree such that the heights of
 *     the two subtrees of any node never differ by more that one.
 *
 */
import java.util.Random;
import java.util.Arrays;

class CheckBalanced {
    /**
     * N(logN) time for this algorithm
     */
    public static boolean isBalance(Tree tree) {
        return isBalance(tree.root);
    }
    
    public static boolean isBalance(Node parent) {
        if (parent == null) {
            return true;
        }
        if (Math.abs(getHeight(parent.children[Node.LEFT]) - getHeight(parent.children[Node.RIGHT])) > 1) {
            return false;
        } else {
            return (isBalance(parent.children[Node.LEFT]) && isBalance(parent.children[Node.RIGHT]));
        }
    }
    
    public static int getHeight(Node parent) {
        if (parent == null) {
            return 1;
        }
        int leftHeight = getHeight(parent.children[Node.LEFT]);
        int rightHeight = getHeight(parent.children[Node.RIGHT]);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    /**
     * N time for this algorithm
     */
    public static boolean isBalance2(Tree tree) {
        if (checkHeight(tree.root) == -1) {
            return false;
        } else {
            return true;
        }
    }
    
    public static int checkHeight(Node parent) {
        if (parent == null) {
            return 1;
        }
        
        int leftHeight = checkHeight(parent.children[Node.LEFT]);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = checkHeight(parent.children[Node.RIGHT]);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
	public static void main(String[] args) {
        Tree tree = new Tree();
//        tree.generateBalanceTree(1000, 0, 200);
        tree.generateRandomData(1000, 0, 200);
        
        tree.inOrderPrint();
        
        System.out.println();
        
        if (isBalance(tree)) {
            System.out.println("Tree is balance!");
        } else {
            System.out.println("Tree is NOT balance!");
        }
        
        if (isBalance2(tree)) {
            System.out.println("Tree is balance!");
        } else {
            System.out.println("Tree is NOT balance!");
        }
	}
}