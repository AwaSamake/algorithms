/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/anagrams
@Language: Java
@Datetime: 17-06-09 21:52
*/

public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			List<String> list;
			String strSorted = sort(str);
			if (map.containsKey(strSorted)) {
				list = map.get(strSorted);
			} else {
				list = new ArrayList<>();
			}
			list.add(str);
			map.put(strSorted, list);
		}
		List<String> result = new ArrayList<String>();
		for (List<String> list : map.values()) {
			if (list.size() > 1) {
				result.addAll(list);
			}
		}
		return result;
	}
	
	private String sort(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
}