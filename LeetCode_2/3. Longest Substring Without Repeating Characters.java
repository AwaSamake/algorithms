import java.util.*;

class Solution {
	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		int begin = 0;
		int end = 0;
		int max = 0;
		int length = s.length();
		while (end < length) {
			if (map.containsKey(s.charAt(end))) {
				int index = map.get(s.charAt(end)) + 1;
				begin = Math.max(begin, index);
			}
			map.put(s.charAt(end), end);
			max = Math.max(max, end - begin + 1);
			end++;
		}
		return max;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.lengthOfLongestSubstring(""));
	}
}