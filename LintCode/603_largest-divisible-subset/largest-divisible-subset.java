/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/largest-divisible-subset
@Language: Java
@Datetime: 17-05-31 03:55
*/

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
		LinkedList<Integer> result = new LinkedList<Integer>();
		int n = nums.length;
		if (n < 1) {
			return result;
		}
		Arrays.sort(nums);
		int[] counts = new int[n];
		int[] divBy = new int[n];
		for (int largerIndex = 0; largerIndex < n; ++largerIndex) {
			// a number is always divisiable by itself
			counts[largerIndex] = 1;
			divBy[largerIndex] = -1;
			// divide larger number by every number smaller
			for (int smallerIndex = 0; smallerIndex < largerIndex; ++smallerIndex) {
				int largerNumber = nums[largerIndex];
				int smallerNumber = nums[smallerIndex];
				// if larger number is divisiable by smaller number
				if (largerNumber % smallerNumber == 0 && counts[largerIndex] < counts[smallerIndex] + 1) {
					// subset count of larger number = subset count of smaller number + 1
					counts[largerIndex] = counts[smallerIndex] + 1;
					divBy[largerIndex] = smallerIndex;
				}
			}
		}
		
		// find the largest number that has max number of divisible number
		int maxIndex = 0;
		for (int i = n - 1; i > 0; --i) {
			if (counts[i] > counts[maxIndex]) {
				maxIndex = i;
			}
		}
		// find number s divisible by it
		while (maxIndex != -1) {
			result.add(nums[maxIndex]);
			maxIndex = divBy[maxIndex];
		}
		return result;
	}
}
