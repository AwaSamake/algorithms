/**
 *
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 *     Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 */

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int iBegin, int iEnd, int[] postorder, int pBegin, int pEnd) {
        if (iBegin > iEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pEnd]);
        int pivot = findPivot(inorder, iBegin, iEnd, postorder[pEnd]);

        root.left = buildTree(inorder, iBegin, pivot - 1, postorder, pBegin, pBegin + pivot - iBegin - 1);
        root.right = buildTree(inorder, pivot + 1, iEnd, postorder, pBegin + pivot - iBegin, pEnd - 1);
        return root;
    }

    private int findPivot(int[] inorder, int begin, int end, int val) {
        for (int i = begin; i <= end; ++i) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}