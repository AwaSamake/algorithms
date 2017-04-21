/**
 *
 * 508. Most Frequent Subtree Sum
 *    Given the root of a tree, you are asked to find the most frequent subtree sum. The 
 *    subtree sum of a node is defined as the sum of all the node values formed by the 
 *    subtree rooted at that node (including the node itself). So what is the most 
 *    frequent subtree sum value? If there is a tie, return all the values with the 
 *    highest frequency in any order.
 *    
 *    Examples 1
 *    Input:
 *    
 *      5
 *     /  \
 *    2   -3
 *    return [2, -3, 4], since all the values happen only once, return all of them in any 
 *    order.
 *    Examples 2
 *    Input:
 *    
 *      5
 *     /  \
 *    2   -5
 *    return [2], since 2 happens twice, however -5 only occur once.
 *    Note: You may assume the sum of values in any subtree is in the range of 32-bit 
 *    signed integer.
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
	public int[] findFrequentTreeSum(TreeNode root) {
		int[] ans = new int[0];
		if (root == null) {
			return ans;
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		sumOf(root, freqMap);
		int mostFreq = 0;
		for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
			if (entry.getValue() > mostFreq) {
				mostFreq = entry.getValue();
				result.clear();
			}
			
			if (entry.getValue() == mostFreq) {
				result.add(entry.getKey());
			}
		}
		ans = new int[result.size()];
		int i = 0;
		for (int num : result) {
			ans[i++] = num;
		}
		return ans;
	}
	
	public int sumOf(TreeNode root, HashMap<Integer, Integer> freqMap) {
		int sum = 0;
		if (root.left != null) {
			sum += sumOf(root.left, freqMap);
		}

		if (root.right != null) {
			sum += sumOf(root.right, freqMap);
		}
		
		sum += root.val;
		freqMap.put(sum, freqMap.getOrDefault(sum, 0) + 1);
		return sum;
	}
}













