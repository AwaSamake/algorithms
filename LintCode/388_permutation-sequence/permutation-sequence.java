/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/permutation-sequence
@Language: Java
@Datetime: 17-06-02 23:13
*/

class Solution {
    /**
     * @param n: n
     * @param k: the kth permutation
     * @return: return the k-th permutation
     */
    public String getPermutation(int n, int k) {
		int[] factorials = new int[n + 1];
		factorials[0] = 1;
		for (int i = 1; i <= n; ++i) {
			factorials[i] = factorials[i - 1] * i;
		}
		
		List<Character> chars = new LinkedList<Character>();
		for (int i = 1; i < 10; ++i) {
			chars.add((char)(i + '0'));
		}
		k--;
		StringBuilder sb = new StringBuilder(k);
		for (int i = 0; i < n; ++i) {
			int index = k / factorials[n - i - 1];
			k %= factorials[n - i - 1];
			char digit = chars.remove(index);
			sb.append(digit);
		}
		return sb.toString();
	}
}
