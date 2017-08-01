import java.util.*;

class Solution {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		if (n == 0) {
			return 0;
		}
		int count = 0;
		while (n != 0) {
			n &= (n - 1);
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.hammingWeight(Integer.MAX_VALUE));
	}
}