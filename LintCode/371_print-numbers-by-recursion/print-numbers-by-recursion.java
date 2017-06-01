/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/print-numbers-by-recursion
@Language: Java
@Datetime: 17-06-01 05:23
*/

public class Solution {
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        ArrayList<Integer> res = new ArrayList<>();
		num(n, 0, res);
		return res;
	}
	
	public void num(int n, int base, ArrayList<Integer> res) {
		if (n > 0) {
			for (int i = 0; i < 10; ++i) {
				num(n - 1, base * 10 + i, res);
			}
		}
		if (n == 0 && base > 0) {
			res.add(base);
		}
	}
}