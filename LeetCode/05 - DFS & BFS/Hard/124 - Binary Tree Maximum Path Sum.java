/**
 *
 * 124. Binary Tree Maximum Path Sum
 *    Given a binary tree, find the maximum path sum.
 *
 *    For this problem, a path is defined as any sequence of nodes from some starting
 *    node to any node in the tree along the parent-child connections. The path must
 *    contain at least one node and does not need to go through the root.
 *
 *    For example:
 *    Given the below binary tree,
 *
 *           1
 *          / \
 *         2   3
 *    Return 6.
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
    private class Result {
        public int sumOfSingleSide = Integer.MIN_VALUE;
        public int sumIncludingRoot = Integer.MIN_VALUE;

        public Result() {
            this.sumOfSingleSide = Integer.MIN_VALUE;
            this.sumIncludingRoot = Integer.MIN_VALUE;
        }

        public Result(int sumOfSingleSide, int sumIncludingRoot) {
            this.sumOfSingleSide = sumOfSingleSide;
            this.sumIncludingRoot = sumIncludingRoot;
        }
    }

    public int maxPathSum(TreeNode root) {
        Result r = maxPathSumHelper(root);
        return r.sumIncludingRoot;
    }

    public Result maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return new Result(0, Integer.MIN_VALUE);
        }

        Result left = maxPathSumHelper(root.left);
        Result right = maxPathSumHelper(root.right);
        int sumOfSingleSide = Math.max(left.sumOfSingleSide, right.sumOfSingleSide) + root.val;
        sumOfSingleSide = Math.max(sumOfSingleSide, 0);

        int sumIncludingRoot = Math.max(left.sumIncludingRoot, right.sumIncludingRoot);
        sumIncludingRoot = Math.max(sumIncludingRoot, left.sumOfSingleSide + right.sumOfSingleSide + root.val);

        return new Result(sumOfSingleSide, sumIncludingRoot);
    }
}