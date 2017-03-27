/**
 *
 * 345. Reverse Vowels of a String
 *     Write a function that takes a string as input and reverse only the vowels of a 
 *     string.
 *     Example 1:
 *         Given s = "hello", return "holle".
 *     Example 2:
 *         Given s = "leetcode", return "leotcede".
 *     Note:
 *         The vowels does not include the letter "y".
 * 
 */
import java.util.*;

public class Solution {
	public String reverseVowels(String s) {
		char[] arr = s.toCharArray();
		String vowels = "aeiouAEIOU";
		int left = 0, right = arr.length - 1;
		while (left < right) {
			while (left < right && vowels.indexOf(arr[left]) < 0) {
				left++;
			}
			while (right > left && vowels.indexOf(arr[right]) < 0) {
				right--;
			}
			if (left >= right) {
			    break;
			}
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
		return new String(arr);
	}
}