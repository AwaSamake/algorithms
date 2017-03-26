/**
 *
 * 350. Intersection of Two Arrays II
 * Given two arrays, write a function to compute their intersection.
 * Example:
 *     Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * Note:
 *     Each element in the result should appear as many times as it shows in both arrays.
 *     The result can be in any order.
 * Follow up:
 *     What if the given array is already sorted? How would you optimize your algorithm?
 *     What if nums1's size is small compared to nums2's size? Which algorithm is better?
 *     What if elements of nums2 are stored on disk, and the memory is limited such that 
 *     you cannot load all elements into the memory at once?
 *
 */
import java.util.*;

public class Solution {
	public int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num : nums1) {
			int count = map.getOrDefault(num, 0);
			count++;
			map.put(num, count);
		}
		
		ArrayList<Integer> dup = new ArrayList<Integer>();
		for (int num : nums2) {
			int count = map.getOrDefault(num, 0);
			if (count > 0) {
				dup.add(num);
				count--;
			}
			map.put(num, count);
		}
		
		int[] result = new int[dup.size()];
		int i = 0;
		for (int num: dup) {
			result[i++] = num;
		}
		return result;
	}
}