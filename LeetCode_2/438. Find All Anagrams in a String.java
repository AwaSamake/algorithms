import java.util.*;

class Solution {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> positions = new ArrayList<Integer>();
		int[] counts = new int[26];
		int length = 0;
		for (char c : p.toCharArray()) {
			counts[c - 'a']++;
			length++;
		}
		
		int begin = 0;
		int current = 0;
		while (true) {
			if (length == 0 && current - begin == p.length()) {
				positions.add(begin);
			}
			if (current - begin < p.length()) {
				if (current >= s.length()) {
					return positions;
				}
				int val = s.charAt(current++) - 'a';
				if (counts[val] > 0) {
					length--;
				}
				counts[val]--;
			} else {
				int val = s.charAt(begin++) - 'a';
				counts[val]++;
				if (counts[val] > 0) {
					length++;
				}
			}
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.findAnagrams("abab", "ab"));
	}
}