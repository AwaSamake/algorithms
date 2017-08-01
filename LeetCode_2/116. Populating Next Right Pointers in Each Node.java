/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		LinkedList<TreeLinkNode> currentLevel = new LinkedList<>();
		LinkedList<TreeLinkNode> nextLevel = new LinkedList<>();
		currentLevel.add(root);
		
		while (!currentLevel.isEmpty()) {
			while (!currentLevel.isEmpty()) {
				TreeLinkNode node = currentLevel.removeFirst();
				node.next = currentLevel.peek();
				if (node.left != null) {
					nextLevel.add(node.left);
				}
				if (node.right != null) {
					nextLevel.add(node.right);
				}
			}
			LinkedList<TreeLinkNode> temp = currentLevel;
			currentLevel = nextLevel;
			nextLevel = temp;
		}
	}
}

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		while (root.left != null) {
			TreeLinkNode temp = root.left;
			while (root != null) {
				if (root.left != null) {
					root.left.next = root.right;
				}
				if (root.right != null && root.next != null && root.next.left != null) {
					root.right.next = root.next.left;
				}
				root = root.next;
			}
			root = temp;
		}
	}
}