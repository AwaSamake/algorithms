/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/intersection-of-two-arrays
@Language: Java
@Datetime: 17-06-03 23:42
*/

public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> set = new HashSet<>();
		for (int num : nums1) {
			set.add(num);
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int num : nums2) {
			if (set.contains(num)) {
				list.add(num);
				set.remove(num);
			}
		}
		int[] result = new int[list.size()];
		int i = 0;
		for (int item : list) {
			result[i++] = item;
		}
		return result;
	}
}