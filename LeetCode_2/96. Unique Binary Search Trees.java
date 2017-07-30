import java.util.*;

class Solution {
	public int numTrees(int n) {
		int[] trees = new int[n + 1];
		trees[0] = 1;
		trees[1] = 1;
		for (int i = 2; i <= n; ++i) {
			for (int j = 0; j < i; ++j) {
				trees[i] += trees[j] * trees[i - j - 1];
			}
		}
		return trees[n];
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.numTrees(5));
	}
}