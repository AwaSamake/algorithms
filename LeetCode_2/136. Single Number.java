public class Solution {
	public int singleNumber(int[] nums) {
		int once = 0;
		for (int num : nums) {
			once ^= num;
		}
		return once;
	}
}