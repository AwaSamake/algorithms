/**
 *
 * 524. Longest Word in Dictionary through Deleting
 *    Given a string and a string dictionary, find the longest string in the dictionary 
 *    that can be formed by deleting some characters of the given string. If there are 
 *    more than one possible results, return the longest word with the smallest 
 *    lexicographical order. If there is no possible result, return the empty string.
 *    
 *    Example 1:
 *    Input:
 *    s = "abpcplea", d = ["ale","apple","monkey","plea"]
 *    
 *    Output: 
 *    "apple"
 *    Example 2:
 *    Input:
 *    s = "abpcplea", d = ["a","b","c"]
 *    
 *    Output: 
 *    "a"
 *    Note:
 *    All the strings in the input will only contain lower-case letters.
 *    The size of the dictionary won't exceed 1,000.
 *    The length of all the strings in the input won't exceed 1,000.
 *
 */
import java.util.*;

public class Solution {
	public String findLongestWord(String s, List<String> d) {
		HashMap<Integer, ArrayList<String>> dictionary = new HashMap<Integer, ArrayList<String>>();
		HashMap<String, String> originalString = new HashMap<String, String>();
		for (String word : d) {
			String sortedWord = sortString(word);
			originalString.put(sortedWord, word);
			
			List<String> list = dictionary.get(word.length());
			if (list == null) {
				list = new ArrayList<Integer>();
			}
			list.add(sortedWord);
			dictionary.put(word.length(), list);
		}
		String sortedStr = sortString(s);
		
		Set<Integer> lengthSet = dictionary.keySet();
		Integer[] lengths =  lengthSet.toArray(new Integer[lengthSet.size()]);
		Arrays.sort(lengths);
		for (int i = lengths.length - 1; i > -1; ++i) {
			ArrayList<String> list = dictionary.get(lengths[i]);
			Collections.sort(list);
			
			for (String word : list) {
				if (compare(sortedStr , word)) {
					return originalString.get(word);
				}
			}
		}
		return "";
	}
	
	private boolean compare(String s1, String s2) {
		int index1 = 0, index2 = 0;
		
		while (index2 < s2.length()) {
			while (index1 < s1.length() && s1.charAt(index1) != s2.charAt(index2)) {
				index1++;
			}
			if (index1 >= s1.length()) {
				return false;
			}
			index2++;
		}
		return true;
	}
	
	private String sortString(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
}