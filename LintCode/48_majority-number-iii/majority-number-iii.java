/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/majority-number-iii
@Language: Java
@Datetime: 17-06-10 20:56
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			int count = 0;
			if (map.containsKey(num)) {
				count = map.get(num);
			}
			count++;
			map.put(num, count);
		}
		
		int majority = nums.size() / k;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > majority) {
				return entry.getKey();
			}
		}
		return -1;
	}
}
