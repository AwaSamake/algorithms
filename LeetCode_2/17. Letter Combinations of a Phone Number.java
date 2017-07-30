import java.util.*;

class Solution {
	public List<String> letterCombinations(String digits) {
		if (digits.length() < 0) {
			return new ArrayList<String>();
		}
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		List<String> combinations = new ArrayList<>();
		combinations.add("");
		for (char digit : digits.toCharArray()) {
			int num = digit - '0';
			if (num < 2 || num > 9) {
				return new ArrayList<String>();
			}
			List<String> newCombinations = new ArrayList<>();
			for (char letter : mapping[num].toCharArray()) {
				for (String combination : combinations) {
					newCombinations.add(combination + letter);
				}
			}
			combinations = newCombinations;
		}
		return combinations;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.letterCombinations("234"));
	}
}