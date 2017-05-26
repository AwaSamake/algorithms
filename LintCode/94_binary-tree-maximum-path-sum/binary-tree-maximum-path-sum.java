/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/binary-tree-maximum-path-sum
@Language: Java
@Datetime: 17-05-25 22:50
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
    
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
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