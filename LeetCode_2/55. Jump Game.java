public class Solution {
	public boolean canJump(int[] nums) {
		int space = 0;
		for (int i = nums.length - 2; i > -1; --i) {
			space++;
			if (nums[i] >= space) {
				space = 0;
			}
		}
		return space == 0;
	}
}