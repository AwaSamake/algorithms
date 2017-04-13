/**
 *
 * 438. Find All Anagrams in a String
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams 
 * in s. Strings consists of lowercase English letters only and the length of both 
 * strings s and p will not be larger than 20,100.* The order of output does not matter.
 * Example 1:
 *     Input:
 *         s: "cbaebabacd" p: "abc"
 *     Output:
 *         [0, 6]
 *     Explanation:
 *         The substring with start index = 0 is "cba", which is an anagram of "abc".
 *         The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *     Input:
 *         s: "abab" p: "ab"
 *     Output:
 *         [0, 1, 2]
 *     Explanation:
 *         The substring with start index = 0 is "ab", which is an anagram of "ab".
 *         The substring with start index = 1 is "ba", which is an anagram of "ab".
 *         The substring with start index = 2 is "ab", which is an anagram of "ab". 
 *
 */
import java.util.*;

public class Solution {
	public List<Integer> findAnagrams(String s, String p) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		String pSorted = sort(p);
		int length = p.length();
		for (int i = 0; i + length <= s.length(); ++i) {
			if (pSorted.equals(sort(s.substring(i, i + length)))) {
				list.add(i);
			}
		}
		return list;
	}
	
	public String sort(String s) {
		char[] sSorted = s.toCharArray();
		Arrays.sort(sSorted);
		return Arrays.toString(sSorted);
	}
}