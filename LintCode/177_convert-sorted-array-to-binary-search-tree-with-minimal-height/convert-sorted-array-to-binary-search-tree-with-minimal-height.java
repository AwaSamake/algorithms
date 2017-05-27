/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/convert-sorted-array-to-binary-search-tree-with-minimal-height
@Language: Java
@Datetime: 17-05-26 20:38
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {  
        return sortedArrayToBST(A, 0, A.length - 1);
    }
    
    public TreeNode sortedArrayToBST(int[] A, int begin, int end) {  
        if (begin > end) {
            return null;
        }
        int mid = begin + (end - begin) / 2;
        TreeNode root = new TreeNode(A[mid]);
        root.left = sortedArrayToBST(A, begin, mid - 1);
        root.right = sortedArrayToBST(A, mid + 1, end);
        return root;
    }
}
