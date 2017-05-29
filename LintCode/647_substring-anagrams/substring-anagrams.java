/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/substring-anagrams
@Language: Java
@Datetime: 17-05-29 04:40
*/

public class Solution {
	/**
	 * @param s a string
	 * @param p a non-empty string
	 * @return a list of index
	 */
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<Integer>();
		if (s.length() < p.length() || p.length() < 1) {
			return list;
		}
		if (s.equals(p)) {
			list.add(0);
			return list;
		}
		
		HashMap<Character, Integer> map = new HashMap<>();
		for (char c : p.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		int pLength = p.length();
		int currentLength = 0;
		int correctChars = 0;
		
		for (int i = 0; i < s.length(); ++i) {
			currentLength++;
			if (map.containsKey(s.charAt(i))) {
				int count = map.get(s.charAt(i));
				if (count > 0) {
					correctChars++;
				}
				map.put(s.charAt(i), count - 1);
			}
			
			if (currentLength == pLength) {
				int begin = i - pLength + 1;
				if (correctChars == pLength) {
					list.add(begin);
				}
				if (map.containsKey(s.charAt(begin))) {
					int count = map.get(s.charAt(begin));
					if (count >= 0) {
						correctChars--;
					}
					map.put(s.charAt(begin), count + 1);
				}
				currentLength--;
			}
		}
		return list;
	}
}