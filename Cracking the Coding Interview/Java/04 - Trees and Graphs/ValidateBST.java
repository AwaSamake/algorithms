/**
 *
 * 4.5 Validate BST
 *     Implement a function to check if a binary tree is a binary search tree.
 *
 */

class ValidateBST {
    public static boolean isValidateBST(Tree tree) {
        return checkBST(tree.root, null, null);
    }
    
    public static boolean checkBST(Node parent, Integer min, Integer max) {
        if (parent == null) {
            return true;
        }
        
        if ((min != null && parent.data <= min) || (max != null && parent.data > max)) {
            return false;
        }
        
        if (!checkBST(parent.children[Node.LEFT], min, parent.data) || !checkBST(parent.children[Node.RIGHT], parent.data, max)) {
            return false;
        }
        
        return true;
    }
        
	public static void main(String[] args) {
		Tree tree = new Tree();
        tree.generateRandomData(100, 0, 100);
        
        if (isValidateBST(tree)) {
            System.out.println("This is a valid BST.");
        } else {
            System.out.println("This is NOT a valid BST.");
        }
	}
}