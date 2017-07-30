import java.util.*;

class Solution {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> combinations = new ArrayList<>();
		combine(n, k, combinations, new LinkedList<Integer>(), 0);
		return combinations;
	}
	
	public void combine(int n, int k, List<List<Integer>> combinations, LinkedList<Integer> combination, int num) {
		if (combination.size() == k) {
			combinations.add(new ArrayList<>(combination));
			return;
		}
		
		for (int i = num + 1; i <= n; ++i) {
			combination.addLast(i);
			combine(n, k, combinations, combination, i);
			combination.removeLast();
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.combine(4, 2));
	}
}