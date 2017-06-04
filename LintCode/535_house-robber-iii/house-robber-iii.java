/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/house-robber-iii
@Language: Java
@Datetime: 17-06-03 19:14
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    class MaxValue {
        public int withRoot;
        public int withoutRoot;
        public MaxValue(int withRoot, int withoutRoot) {
            this.withRoot = withRoot;
            this.withoutRoot = withoutRoot;
        }
    }
    
    /**
     * @param root: The root of binary tree.
     * @return: The maximum amount of money you can rob tonight
     */
    public int houseRobber3(TreeNode root) {
        MaxValue max = houseRobber3Helper(root);
        return Math.max(max.withRoot, max.withoutRoot);
    }
    
    public MaxValue houseRobber3Helper(TreeNode root) {
        if (root == null) {
            return new MaxValue(0, 0);
        }
        MaxValue left = houseRobber3Helper(root.left);
        MaxValue right = houseRobber3Helper(root.right);
        int withRoot = root.val + left.withoutRoot + right.withoutRoot;
        
        int leftMax = Math.max(left.withRoot, left.withoutRoot);
        int rightMax = Math.max(right.withRoot, right.withoutRoot);
        int withoutRoot = leftMax + rightMax;
        return new MaxValue(withRoot, withoutRoot);
    }
}