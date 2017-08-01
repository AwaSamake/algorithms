public class Solution {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> combinations = new ArrayList<>();
		permute(nums, combinations, new ArrayList<Integer>(), new HashSet<Integer>());
		return combinations;
	}
	
	public void permute(int[] nums, List<List<Integer>> combinations, List<Integer> combination, Set<Integer> set) {
		if (combination.size() == nums.length) {
			combinations.add(new ArrayList(combination));
			return;
		}
		for (int num : nums) {
			if (!set.contains(num)) {
				set.add(num);
				combination.add(num);
				permute(nums, combinations, combination, set);
				set.remove(num);
				combination.remove(combination.size() - 1);
			}
		}
	}
}