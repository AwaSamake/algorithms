/**
 *
 * 049. Group Anagrams
 *     Given an array of strings, group anagrams together.
 *     
 *     For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 *     Return:
 *     
 *     [
 *       ["ate", "eat","tea"],
 *       ["nat","tan"],
 *       ["bat"]
 *     ]
 *     Note: All inputs will be in lower-case.
 *     
 *
 */
import java.util.*;

public class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String s = new String(chars);
			List<String> group = map.getOrDefault(s, new ArrayList<String>());
			group.add(str);
			map.put(s, group);
		}
		List<List<String>> result = new ArrayList<List<String>>();
		for (List<String> list : map.values()) {
			result.add(list);
		}
		return result;
	}
}