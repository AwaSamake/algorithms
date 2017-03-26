/**
 *
 * 349. Intersection of Two Arrays
 * Given two arrays, write a function to compute their intersection.* Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * Note:
 *     Each element in the result must be unique.
 *     The result can be in any order.
 *
 */
import java.util.*;

public class Solution {
	public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int num : nums1) {
			set.add(num);
		}
		
		HashSet<Integer> dup = new HashSet<Integer>();
		for (int num : nums2) {
			if (set.contains(num)) {
				dup.add(num);
			}
		}
		int[] intersect = new int[dup.size()];
		int i = 0;
		for (int num : dup) {
			intersect[i++] = num;
		}
		return intersect;
	}
}