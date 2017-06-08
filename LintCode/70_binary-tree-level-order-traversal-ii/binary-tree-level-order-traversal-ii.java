/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/binary-tree-level-order-traversal-ii
@Language: Java
@Datetime: 17-06-08 05:32
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
     * @param root: The root of binary tree.
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> levels = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return levels;
        }
        ArrayList<Integer> level = new ArrayList<Integer>();
        Queue<TreeNode> curLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        curLevel.add(root);
        while (!curLevel.isEmpty()) {
            while (!curLevel.isEmpty()) {
                TreeNode node = curLevel.remove();
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
                level.add(node.val);
            }
            Queue<TreeNode> temp = curLevel;
            curLevel = nextLevel;
            nextLevel = temp;
            levels.add(level);
            level = new ArrayList<Integer>();
        }
        ArrayList<ArrayList<Integer>> reversedLevels = new ArrayList<ArrayList<Integer>>();
        for (int i = levels.size() - 1; i > -1; --i) {
            reversedLevels.add(levels.get(i));
        }
        return reversedLevels;
    }
}