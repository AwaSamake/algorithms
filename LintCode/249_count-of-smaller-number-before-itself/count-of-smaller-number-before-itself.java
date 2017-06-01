/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/count-of-smaller-number-before-itself
@Language: Java
@Datetime: 17-05-31 23:35
*/

public class Solution {
    class Node {
        public int count;
        public int val;
        public Node left;
        public Node right;
        public Node(int val) {
            this.val = val;
            left = null;
            right = null;
            count = 1;
        }
        
        public void increment() {
            count++;
        }
    }
    
    
    /**
     * @param A: An integer array
     * @return: Count the number of element before this element 'ai' is
     *          smaller than it and return count number array
     */
    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        Node root = null;
        ArrayList<Integer> counts = new ArrayList<Integer>();
        for (int a : A) {
            root = insert(root, a);
            counts.add(getCount(root, a));
        }
        return counts;
    }
    
    private int getCount(Node root, int val) {
        if (root == null) {
            return 0;
        }
        if (root.val == val) {
            if (root.left == null) {
                return 0;
            } else {
                return root.left.count;
            }
        }
        if (root.val < val) {
            return root.count - (root.right == null ? 0 : root.right.count)
                + getCount(root.right, val);
        } else {
            return getCount(root.left, val);
        }
    }
    
    private Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        root.increment();
        if (root.val < val) {
            root.right = insert(root.right, val);
        } else if (root.val > val) {
            root.left = insert(root.left, val);
        }
        return root;
    }
}
