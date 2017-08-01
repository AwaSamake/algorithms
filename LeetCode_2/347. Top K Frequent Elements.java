import java.util.*;

class Solution {
	public List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, (a, b)-> {
			return b.getValue() - a.getValue();
		});
		List<Integer> result = new ArrayList<>(k);
		for (int i = 0; i < k; ++i) {
			result.add(list.get(i).getKey());
		}
		return result;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.topKFrequent(new int[] {1,1,1,2,2,3,3,3,3}, 2));
	}
}