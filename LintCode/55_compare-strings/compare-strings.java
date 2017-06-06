/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/compare-strings
@Language: Java
@Datetime: 17-06-06 23:40
*/

public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (char c: A.toCharArray()) {
			map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
		}
		for (char c: B.toCharArray()) {
			if (!map.containsKey(c) || map.get(c) < 1) {
				return false;
			} else {
				map.put(c, map.get(c) - 1);
			}
		}
		return true;
	}
}