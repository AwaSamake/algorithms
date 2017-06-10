/**
 *
 * 105. Construct Binary Tree from Preorder and Inorder Traversal 
 *     Given preorder and inorder traversal of a tree, construct the binary tree.
 *     
 *     Note:
 *     You may assume that duplicates do not exist in the tree.
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

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0 || preorder.length != inorder.length) {
			return null;
		}
		return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}
	
	public TreeNode buildTree(int[] preorder, int preorderBegin, int preorderEnd,
							  int[] inorder, int inorderBegin, int inorderEnd) {
		if (inorderEnd < inorderBegin) {
			return null;
		}
		
		TreeNode node = new TreeNode(preorder[preorderBegin]);
		
		int position = findPosition(inorder, inorderBegin, inorderEnd, node.val);
		
//		node.left = buildTree(preorder, preorderBegin + 1, position, inorder, inorderBegin, position - 1);
//		node.right = buildTree(preorder, position + 1, preorderEnd, inorder, position + 1, inorderEnd);
		node.left = buildTree(preorder, preorderBegin + 1, preorderBegin + position - inorderBegin, inorder, inorderBegin, position - 1);
		node.right = buildTree(preorder, position + 1 - inorderEnd + preorderEnd, preorderEnd, inorder, position + 1, inorderEnd);

		
		return node;
	}
	
	public int findPosition(int[] inorder, int begin, int end, int key) {
		for (int i = begin; i <= end; ++i) {
			if (inorder[i] == key) {
				return i;
			}
		}
		return -1;
	}
}

class Travel {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList result = new ArrayList();

		if (root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			ArrayList<Integer> level = new ArrayList<Integer>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode head = queue.poll();
				level.add(head.val);
				if (head.left != null) {
					queue.offer(head.left);
				}
				if (head.right != null) {
					queue.offer(head.right);
				}
			}
			result.add(level);
		}

		return result;
	}
}

class test {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] inorder = new int[] {1,2,3,4,5,6,7};
		int[] preorder = new int[] {4,2,1,3,6,5,7};
		
		TreeNode root = s.buildTree(preorder, inorder);
		
		Travel t = new Travel();
		
		System.out.println(t.levelOrder(root));
	}
}







