/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/binary-tree-path-sum
@Language: Java
@Datetime: 17-06-02 04:02
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
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        binaryTreePathSum(root, target, combinations, combination);
        return combinations;
    }
    
    public void binaryTreePathSum(TreeNode root, int target, List<List<Integer>> combinations, List<Integer> combination) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null && target == root.val) {
            combination.add(root.val);
            combinations.add(new ArrayList<Integer>(combination));
            combination.remove(combination.size() - 1);
            return;
        }
        
        combination.add(root.val);
        binaryTreePathSum(root.left,  target - root.val, combinations, combination);
        binaryTreePathSum(root.right, target - root.val, combinations, combination);
        combination.remove(combination.size() - 1);
    }
}