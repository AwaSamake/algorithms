/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/single-number-iii
@Language: Java
@Datetime: 17-06-06 21:35
*/

public class Solution {
    /**
     * @param A : An integer array
     * @return : Two integers
     */
    	public List<Integer> singleNumberIII(int[] A) {
		int xor = 0;
		for (int a : A) {
			xor ^= a;
		}
		int lastBit = xor - (xor & (xor - 1));
		int one = 0;
		int two = 0;
		for (int a : A) {
			if ((a & lastBit) == 0) {
				one ^= a;
			} else {
				two ^= a;
			}
		}
		List<Integer> list = new ArrayList<>();
		list.add(one);
		list.add(two);
		return list;
	}
}