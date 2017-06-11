/**
 *
 * 4.10 Check Subtree
 *     T1 and T2 are two very large binary trees, with T1 much bigger that T2. Create an
 *     algorithm to determine if T2 is a subtree of T1.
 *
 */
class CheckSubtree {
    /**
     * Solution #1
     */
    public static boolean containsTree1(Node t1, Node t2) {
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();
        
        getOrderString(t1, string1);
        getOrderString(t2, string2);
        
        return string1.indexOf(string2.toString()) != -1;
    }
    
    public static void getOrderString(Node node, StringBuilder sb) {
        if (node == null) {
            sb.append("X");
            return;
        }
        sb.append(node.data + " ");
        getOrderString(node.left, sb);
        getOrderString(node.right, sb);
    }
    
    /**
     * Solution #2
     */
    public static boolean containsTree2(Node t1, Node t2) {
        if (t2 == null) {
            return true;
        }
        return subTree(t1, t2);
    }
    
    boolean subTree(Node r1, Node r2) {
        if (r1 == null) {
            return false;
        } else if (r2.data == r2.data && matchTree(r1, r2));
    }
    
    public static boolean matchTree(Node r2, Node r2) {
        if (r1 == null && r2 == null) {
            return true;
        } else if (r1 == null || r2 == null) {
            return false;
        } else if (r1.data != r2.data) {
            return false;
        } else {
            return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
        }
    }
    
    
	public static void main(String[] args) {
		
	}
}