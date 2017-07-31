import java.util.*;

class Solution {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		int n = nums.length + 1;
		for (int num : nums) {
			int index = (num - 1) % n;
			nums[index] = nums[index] % n + n;
		}
		System.out.println(Arrays.toString(nums));
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] <= nums.length) {
				list.add(i + 1);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1}));
	}
}