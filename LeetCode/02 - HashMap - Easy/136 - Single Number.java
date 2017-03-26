/**
 *
 * 136. Single Number
 * Given an array of integers, every element appears twice except for one. 
 * Find that single one.
 * Note:
 *     Your algorithm should have a linear runtime complexity. Could you implement it 
 *     without using extra memory?
 *
 */
import java.util.*;

public class Solution {
	public int singleNumber(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int num : nums) {
			if (set.contains(num)) {
				set.remove(num);
			} else {
				set.add(num);
			}
		}
		Integer[] arr = set.toArray(new Integer[set.size()]);
		return arr.length == 1 ? arr[0] : -1;
	}
}