/**
 *
 *  017. Letter Combinations of a Phone Number
 *    Given a digit string, return all possible letter combinations that the 
 *    number could represent.
 *    
 *    A mapping of digit to letters (just like on the telephone buttons) is 
 *    given below.
 *    
 *    Input:Digit string "23"
 *    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *    Note:
 *    Although the above answer is in lexicographical order, your answer 
 *    could be in any order you want.
 *
 */
import java.util.*;

public class Solution {
	public List<String> letterCombinations(String digits) {
		HashMap<Character, String> keyMap = setUp();
		List<String> combinatrions = new ArrayList<String>();
		for (char digit: digits.toCharArray()) {
			if (keyMap.containsKey(digit)) {
				List<String> newCombinations = new ArrayList<String>();
				for (char c: keyMap.get(digit).toCharArray()) {
					if (combinatrions.isEmpty()) {
						newCombinations.add(String.valueOf(c));
					} else {
						for (String combination: combinatrions) {
							newCombinations.add(combination + c);
						}
					}
				}
				combinatrions = newCombinations;
			}
		}
		return combinatrions;
	}
	
	private HashMap<Character, String> setUp() {
		char[] keys = new char[]{'2', '3', '4', '5', '6', '7', '8', '9'};
		String[] values = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		HashMap<Character, String> map = new HashMap<>();
		for (int i = 0; i < keys.length; ++i) {
			map.put(keys[i], values[i]);
		}
		return map;
	}
}