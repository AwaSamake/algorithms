/**
 *
 * 347. Top K Frequent Elements
 *    Given a non-empty array of integers, return the k most frequent elements.
 *    
 *    For example,
 *    Given [1,1,1,2,2,3] and k = 2, return [1,2].
 *    
 *    Note: 
 *    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 *    Your algorithm's time complexity must be better than O(n log n), where n is the 
 *    array's size.
 *
 */
import java.util.*;

public class Solution {
	public List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		
		for (int num : nums) {
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		}
		
		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<Map.Entry<Integer, Integer>>((a, b) -> (b.getValue() - a.getValue()));
		
		for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
			maxHeap.add(entry);
		}
		
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < k; ++i) {
			result.add(maxHeap.poll().getKey());
		}
		return result;
	}
}