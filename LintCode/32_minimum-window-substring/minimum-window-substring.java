/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/minimum-window-substring
@Language: Java
@Datetime: 17-06-04 23:52
*/

public class Solution {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
		int[] sourceHash = new int[256];
		int[] targetHash = new int[256];
		
		for (char c : target.toCharArray()) {
			targetHash[c]++;
		}
		
		int wanted = target.length();
		int minBegin = -1;
		int minEnd = source.length();
		int minLength = minEnd;
		int begin = 0;
		int end = minEnd; 
		for (int i = 0; i < source.length(); ++i) {
			int hash = (int) source.charAt(i);
			sourceHash[hash]++;
			if (sourceHash[hash] <= targetHash[hash]) {
				wanted--;
			}
			if (wanted == 0) {
				end = i;
				while (sourceHash[source.charAt(begin)] > targetHash[source.charAt(begin)]) {
					sourceHash[source.charAt(begin)]--;
					begin++;
				}
				if (end - begin + 1 <= minLength) {
					minLength = end - begin + 1;
					minBegin = begin;
					minEnd = end;
				}
				sourceHash[source.charAt(begin)]--;
				begin++;
				wanted++;
			}
		}
		if (minBegin == -1) {
			return "";
		}
		return source.substring(minBegin, minEnd + 1);
	}
}