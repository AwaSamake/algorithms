/**
 *
 * 520. Detect Capital
 *     Given a word, you need to judge whether the usage of capitals in it is right or 
 *     not. 
 *     We define the usage of capitals in a word to be right when one of the following 
 *     cases holds: 
 *         1. All letters in this word are capitals, like "USA". 
 *         2. All letters in this word are not capitals, like "leetcode". 
 *         3. Only the first letter in this word is capital if it has more than one 
 *         letter, like "Google". 
 *     Otherwise, we define that this word doesn't use capitals in a right way. 
 *     Example 1: 
 *         Input: "USA" 
 *         Output: True 
 *     Example 2: 
 *         Input: "FlaG" 
 *         Output: False 
 *     Note: The input will be a non-empty word consisting of uppercase and lowercase 
 *     latin letters.
 * 
 */
import java.util.*;

public class Solution {
	public boolean detectCapitalUse(String word) {
		if (word.length() < 1) {
			return false;
		}
		char[] arr = word.toCharArray();
		if (allCapital(arr) || allNotCapital(arr) || onlyFirstCapital(arr)) {
			return true;
		}
		return false;
	}
	
	public boolean allCapital(char[] word) {
		for (char c : word) {
			if (Character.isLowerCase(c)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean allNotCapital(char[] word) {
		for (char c : word) {
			if (!Character.isLowerCase(c)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean onlyFirstCapital(char[] word) {
		if (Character.isLowerCase(word[0])) {
			return false;
		}
		for (int i = 1; i < word.length; ++i) {
			if (!Character.isLowerCase(word[i])) {
				return false;
			}
		}
		return true;
	}
}