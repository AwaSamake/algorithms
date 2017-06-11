/**
 *
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 *     Given preorder and inorder traversal of a tree, construct the binary tree.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int pBegin, int pEnd, int[] inorder, int iBegin, int iEnd) {
        if (iBegin > iEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pBegin]);
        int pivot = findPivot(inorder, iBegin, iEnd, preorder[pBegin]);

        root.left = buildTree(preorder, pBegin + 1, pBegin + pivot - iBegin,
                              inorder, iBegin, pivot - 1);
        root.right = buildTree(preorder, pivot - iEnd + pEnd + 1, pEnd,
                               inorder, pivot + 1, iEnd);
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