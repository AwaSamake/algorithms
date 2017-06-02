/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/median
@Language: Java
@Datetime: 17-06-01 21:05
*/

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
	public int median(int[] nums) {
		int n = nums.length;
		if (n < 1) {
			return -1;
		}
		Queue<Integer> min = new PriorityQueue<Integer>(n);
		for (int num : nums) {
			min.add(num);
		}
		if ((n & 1) == 0) {
			n >>= 1;
			n -= 1;
		} else {
			n >>= 1;
		}
		int i = 0;
		while (i < n) {
			min.remove();
			i++;
		}
		return min.remove();
	}
}
