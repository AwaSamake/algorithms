/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/majority-number-ii
@Language: Java
@Datetime: 17-06-10 20:43
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
		int a = 0, b = 0;
		int aCount = 0, bCount = 0;
		
		for (int num : nums) {
			if (num == a) {
				aCount++;
			} else if (num == b) {
				bCount++;
			} else if (aCount == 0) {
				a = num;
				aCount = 1;
			} else if (bCount == 0) {
				b = num;
				bCount = 1;
			} else {
				aCount--;
				bCount--;
			}
		}
		aCount = 0;
		bCount = 0;
		for (int num : nums) {
			if (num == a) {
				aCount++;
			} else if (num == b) {
				bCount++;
			}
		}
		if (aCount > (nums.size() / 3)) {
			return a;
		} else if (bCount > (nums.size() / 3)) {
			return b;
		} else {
			return -1;
		}
	}
}
