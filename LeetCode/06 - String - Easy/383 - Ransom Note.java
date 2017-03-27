/**
 *
 * 383. Ransom Note
 *     Given an arbitrary ransom note string and another string containing letters from 
 *     all the magazines, write a function that will return true if the ransom note can 
 *     be constructed from the magazines ; otherwise, it will return false. 
 *     Each letter in the magazine string can only be used once in your ransom note. 
 *     Note: 
 *         You may assume that both strings contain only lowercase letters. 
 *         canConstruct("a", "b") -> false 
 *         canConstruct("aa", "ab") -> false 
 *         canConstruct("aa", "aab") -> true
 * 
 */
import java.util.*;

public class Solution {
	public boolean canConstruct(String ransomNote, String magazine) {
		HashMap<Character, Integer> magazineMap = putIntoMap(magazine);
		HashMap<Character, Integer> noteMap = putIntoMap(ransomNote);
		
		for (Map.Entry<Character, Integer> entry : noteMap.entrySet()) {
			int count = magazineMap.getOrDefault(entry.getKey(), 0);
			if (count < entry.getValue()) {
				return false;
			}
		}
		return true;
	}
	
	public HashMap<Character, Integer> putIntoMap(String str) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c: str.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		return map;
	}
}