/**
 *
 * 500. Keyboard Row
 * Given a List of words, return the words that can be typed using letters of alphabet on 
 * only one row's of American keyboard.
 * Example 1:
 *     Input: 
 *         ["Hello", "Alaska", "Dad", "Peace"]
 *     Output: 
 *         ["Alaska", "Dad"]
 * Note:
 *     You may use one character in the keyboard more than once.
 *     You may assume the input string will only contain letters of alphabet.
 *
 */
import java.util.*;

public class Solution {
	public String[] findWords(String[] words) {
		String[] keys = "qwertyuiop asdfghjkl zxcvbnm".split(" ");
		HashMap<Character, Integer> keyLine = new HashMap<Character, Integer>();
		ArrayList<String> results = new ArrayList<String>();
		
		for (int i = 0; i < keys.length; ++i) {
			for (char c: keys[i].toCharArray()) {
				keyLine.put(c, i);
			}
		}
		boolean sameLine = true;
		for (String word : words) {
			if (word.length() > 0 && keyLine.containsKey(Character.toLowerCase(word.charAt(0)))) {
				int line = keyLine.get(Character.toLowerCase(word.charAt(0)));
				for (char c : word.toCharArray()) {
					if (keyLine.get(Character.toLowerCase(c)) != line) {
						sameLine = false;
						break;
					}
				}
				if (sameLine) {
					results.add(word);
				}
				sameLine = true;
			}
		}
		String[] ans = new String[results.size()];
		int i = 0;
		for (String str: results) {
			ans[i++] = str;
		}
		return ans;
	}
}