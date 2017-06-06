/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/first-position-unique-character
@Language: Java
@Datetime: 17-06-06 23:05
*/

public class Solution {
    /**
     * @param s a string
     * @return it's index
     */
    public int firstUniqChar(String s) {
		HashMap<Character,Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			map.put(c, map.containsKey(c) ? map.get(c) + 1: 1);
		}
		for (int i = 0; i < s.length(); ++i) {
			if (map.get(s.charAt(i)) < 2) {
				return i;
			}
		}
		return -1;
	}
}