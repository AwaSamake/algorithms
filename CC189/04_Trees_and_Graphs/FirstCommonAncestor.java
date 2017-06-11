/**
 *
 * 4.8 First Common Ancestor
 *     Design an algorithm and write code to find the first common ancestor of two nodes
 *     in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This
 *     is not necessarily a binary search tree.
 *
 */
class FirstCommonAncestor {
    /**
     * Solution #1: With Links to Parents
     */
    public static Node commonAncestor1(Node p, Node q) {
        int delta = depth(p) - depth(q);
        Node first = delta > 0 ? q : p;
        Node second = delta > 0 ? p : q;
        second = goUpBy(second, Math.abs(delta));
        
        while (first != second && first != null && second != null) {
            first = first.parent;
            second = second.parent;
        }
        return first == null || second == null ? null : first;
    }
    
    public static Node goUpBy(Node node, int delta) {
        while(delta > 0 && node != null) {
            node = node.parent;
            delta--;
        }
        return node;
    }
    
    public static int depth(Node node) {
        int depth = 0;
        while (node != null) {
            node = node.parent;
            depth++;
        }
        return depth;
    }
    
    /**
     * Solution #2: With Links to Parents
     */
    public static Node commonAncestor2(Node root, Node p, Node q) {
        if (!covers(root, p) || !covers(root, q)) {
            return null;
        } else if (covers(p, q)) {
            return p;
        } else if (covers(q, p)) {
            return q;
        }
        
        Node sibling = getSibling(p);
        Node parent = p.parent;
        while (!cover(sibling, q)) {
            sibling = getSibling(parent);
            parent = parent.parent;
        }
        return parent;
    }
    
    public static boolean covers(Node root, Node p) {
        if (root == null) {
            return false;
        }
        if (root == p) {
            return true;
        }
        return cover(root.left, p) || covers(root.right, p);
    }
    
    public static Node getSibling(Node node) {
        if (node == null || node.parent == null) {
            return null;
        }
        
        Node parent = node.parent;
        return parent.left == node ? parent.right : parent.left;
    }
    
    /**
     * Solution #3: Without Links to Parents
     */
    public static Node commonAncestor3(Node root, Node p, Node q) {
        if (!covers(root, p) || !covers(root, q)) {
            return null;
        }
        return ancestorHelper(root, p, q);
    }
    
    Node ancestorHelper(Node root, Node p, Node q) {
        if (root == null || root == p || root == q) {
            return root;
        }
    }

    /**
     * Solution #4: Without Links to Parents
     */
    public static Node commonAncestor4(Node root, Node p, Node q) {
        if (root == null) {
            return null;
        }
        if (root == p && root == q) {
            return root;
        }
        
        Node x = commonAncestor4(root.left, p, q);
        if (x != null && x != p && x != q) {
            return x;
        }
        
        Node y = commonAncestor4(root, p, q);
        if (y != null && y Q= p && y != q) {
            return y;
        }
        
        if (x != null && y != null) {
            return root;
        } else if (root == p || root == q) {
            return root;
        } else {
            return x == null ? y : x;
        }
    }
    
	public static void main(String[] args) {
		
	}
}































