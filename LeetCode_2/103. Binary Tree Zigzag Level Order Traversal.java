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
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> levels = new ArrayList<>();
		if (root == null) {
			return levels;
		}
		ArrayList<TreeNode> currentLevel = new ArrayList<>();
		ArrayList<TreeNode> nextLevel = new ArrayList<>();
		currentLevel.add(root);
		boolean reverse = false;
		while (!currentLevel.isEmpty()) {
			for (TreeNode node : currentLevel) {
				if (node.left != null) {
					nextLevel.add(node.left);
				}
				if (node.right != null) {
					nextLevel.add(node.right);
				}
			}
			List<Integer> values = getAllValues(currentLevel, reverse);
			currentLevel.clear();
			reverse = !reverse;
			levels.add(values);
			ArrayList<TreeNode> temp = currentLevel;
			currentLevel = nextLevel;
			nextLevel = temp;
		}
		return levels;
	}
	
	private List<Integer> getAllValues(List<TreeNode> list, boolean reverse) {
		List<Integer> values = new ArrayList<Integer>();
		if (reverse) {
			for (int i = list.size() - 1; i > -1; --i) {
				values.add(list.get(i).val);
			}
		} else {
			for (TreeNode node : list) {
				values.add(node.val);
			}
		}
		return values;
	}
}